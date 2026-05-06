package com.nicolas.iservice.pedidos.services.impl;

import com.nicolas.iservice.pedidos.client.ServicoBancarioClient;
import com.nicolas.iservice.pedidos.model.DadosPagamento;
import com.nicolas.iservice.pedidos.model.Pedido;
import com.nicolas.iservice.pedidos.model.enums.StatusPedido;
import com.nicolas.iservice.pedidos.model.enums.TipoPagamento;
import com.nicolas.iservice.pedidos.model.exceptions.ItemNaoEncontradoException;
import com.nicolas.iservice.pedidos.repositories.ItemPedidoRepositoy;
import com.nicolas.iservice.pedidos.repositories.PedidoRepository;
import com.nicolas.iservice.pedidos.services.PedidoService;
import com.nicolas.iservice.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepositoy itemPedidoRepositoy;
    private final PedidoValidator validator;
    private final ServicoBancarioClient servicoBancarioClient;

    @Transactional
    public Pedido criarPedido(Pedido pedido){
        validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitacaoPagamento(pedido);
        return pedido;
    }

    @Override
    public void atualizarStatusPagamento(Long codigoPedido, String chavePagamento, boolean sucess, String observacao) {

        Optional<Pedido> pedidoEncontrado = repository.findByCodigoAndChavePagamento(codigoPedido, chavePagamento);
        if(pedidoEncontrado.isEmpty()){
            var msg = String.format("Pedido não encontrado para o codigo: %d e chave pagamento %s", codigoPedido, chavePagamento);
            log.error(msg);
        }

        Pedido pedido = pedidoEncontrado.get();
        if(sucess){
            pedido.setStatus(StatusPedido.PAGO);
        }else {
            pedido.setStatus(StatusPedido.ERRO_PAGAMENTO);
            pedido.setObservacoes(observacao);
        }

        repository.save(pedido);
    }

    private void enviarSolicitacaoPagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepositoy.saveAll(pedido.getItens());
    }

    @Transactional
    public void adicionarNovoPagamento(Long codigoPedido, String dadosCartao, TipoPagamento tipo) {
        var pedidoEncontrado = repository.findById(codigoPedido);

        if(pedidoEncontrado.isEmpty()){
            throw new ItemNaoEncontradoException("Pedido não encontrado para o codigo informado.");
        }

        var pedido = pedidoEncontrado.get();

        DadosPagamento dadosPagamento = new DadosPagamento();
        dadosPagamento.setTipoPagamento(tipo);
        dadosPagamento.setDados(dadosCartao);

        pedido.setDadosPagamento(dadosPagamento);
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setObservacoes("Novo pagamento realizado, aguardando o novo processamento.");

        String novaChavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(novaChavePagamento);

        repository.save(pedido);
    }
}
