package com.nicolas.iservice.pedidos.repositories;

import com.nicolas.iservice.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
