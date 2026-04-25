package com.nicolas.iservice.pedidos.controllers.mappers;

import com.nicolas.iservice.pedidos.controllers.dto.NovoPedidoDTO;
import com.nicolas.iservice.pedidos.model.Pedido;

public interface PedidoMapper {

    Pedido map(NovoPedidoDTO dto);
}
