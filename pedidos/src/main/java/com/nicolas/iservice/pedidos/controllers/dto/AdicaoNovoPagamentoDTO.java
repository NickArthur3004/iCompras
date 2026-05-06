package com.nicolas.iservice.pedidos.controllers.dto;

import com.nicolas.iservice.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(Long codigoPedido,
                                     String dados,
                                     TipoPagamento tipoPagamento) {
}
