package com.nicolas.iservice.pedidos.repositories;

import com.nicolas.iservice.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByCodigoAndChavePagamento(Long codigo, String chavePagamento);
}
