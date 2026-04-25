package com.nicolas.iservice.pedidos.controllers.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(Long codigoProduto,
                            Integer quantidade,
                            BigDecimal valorUnitario) {
}
