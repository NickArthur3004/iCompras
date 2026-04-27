package com.nicolas.iservice.pedidos.controllers.mappers;

import com.nicolas.iservice.pedidos.controllers.dto.ItemPedidoDTO;
import com.nicolas.iservice.pedidos.controllers.dto.NovoPedidoDTO;
import com.nicolas.iservice.pedidos.model.ItemPedido;
import com.nicolas.iservice.pedidos.model.Pedido;
import com.nicolas.iservice.pedidos.model.enums.StatusPedido;
import org.jspecify.annotations.NonNull;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    Pedido map(NovoPedidoDTO dto);

    @Named("mapItens")
    default List<ItemPedido> mapItens(List<ItemPedidoDTO> dtos) {
        return dtos.stream().map(ITEM_PEDIDO_MAPPER::map).toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Pedido pedido) {
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setDatePedido(LocalDateTime.now());

        var total = calcularTotal(pedido);
        pedido.setTotal(total);

        pedido.getItens().forEach(item -> item.setPedido(pedido));
    }

    private static BigDecimal calcularTotal(Pedido pedido) {
        return pedido.getItens().stream().map(
                item -> item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()))
        ).reduce(BigDecimal.ZERO, BigDecimal::add).abs();
    }
}
