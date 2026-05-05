package com.nicolas.iservice.pedidos.controllers.dto;

public record RecebimentoCallbackPagamentoDTO(Long codigo,
                                              String chavePagamento,
                                              boolean status,
                                              String observacao) {
}
