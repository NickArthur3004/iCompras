package com.nicolas.iservice.pedidos.services;

import com.nicolas.iservice.pedidos.model.Pedido;
import com.nicolas.iservice.pedidos.model.enums.TipoPagamento;

public interface PedidoService {

    Pedido criarPedido(Pedido pedido);

    void atualizarStatusPagamento(Long codigoPedido, String chavePagamento, boolean sucess, String observacao);

    void adicionarNovoPagamento(Long codigoPedido, String dadosCartao, TipoPagamento tipo);
}
