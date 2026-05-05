package com.nicolas.iservice.pedidos.services;

import com.nicolas.iservice.pedidos.model.Pedido;

public interface PedidoService {

    Pedido criarPedido(Pedido pedido);

    void atualizarStatusPagamento(Long codigoPedido, String chavePagamento, boolean sucess, String observacao);
}
