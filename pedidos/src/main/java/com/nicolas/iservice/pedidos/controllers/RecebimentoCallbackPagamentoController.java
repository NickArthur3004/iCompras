package com.nicolas.iservice.pedidos.controllers;

import com.nicolas.iservice.pedidos.controllers.dto.RecebimentoCallbackPagamentoDTO;
import com.nicolas.iservice.pedidos.model.Pedido;
import com.nicolas.iservice.pedidos.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/callback-pagamentos")
@RequiredArgsConstructor
public class RecebimentoCallbackPagamentoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusPagamento(@RequestBody RecebimentoCallbackPagamentoDTO dto,
                                                           @RequestHeader(required = true, name = "apiKey") String apiKey) {
        pedidoService.atualizarStatusPagamento(dto.codigo(),
                dto.chavePagamento(),
                dto.status(), dto.observacao());

        return ResponseEntity.ok().build();
    }
}
