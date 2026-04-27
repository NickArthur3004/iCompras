package com.nicolas.iservice.pedidos.services.impl;

import com.nicolas.iservice.pedidos.client.ServicoBancarioClient;
import com.nicolas.iservice.pedidos.model.Pedido;
import com.nicolas.iservice.pedidos.repositories.ItemPedidoRepositoy;
import com.nicolas.iservice.pedidos.repositories.PedidoRepository;
import com.nicolas.iservice.pedidos.services.PedidoService;
import com.nicolas.iservice.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
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

    private void enviarSolicitacaoPagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepositoy.saveAll(pedido.getItens());
    }
}
