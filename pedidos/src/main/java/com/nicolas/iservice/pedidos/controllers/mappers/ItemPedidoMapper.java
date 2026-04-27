package com.nicolas.iservice.pedidos.controllers.mappers;

import com.nicolas.iservice.pedidos.controllers.dto.ItemPedidoDTO;
import com.nicolas.iservice.pedidos.controllers.dto.NovoPedidoDTO;
import com.nicolas.iservice.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedido map(ItemPedidoDTO dto);
}
