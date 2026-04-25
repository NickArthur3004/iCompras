package com.nicolas.iservice.pedidos.repositories;

import com.nicolas.iservice.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepositoy extends JpaRepository<ItemPedido, Long> {
}
