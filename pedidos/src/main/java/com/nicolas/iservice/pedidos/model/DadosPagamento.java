package com.nicolas.iservice.pedidos.model;

import com.nicolas.iservice.pedidos.model.enums.TipoPagamento;
import lombok.Data;

@Data
public class DadosPagamento {

    private String dados;
    private TipoPagamento tipoPagamento;

}

