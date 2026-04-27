package com.nicolas.iservice.pedidos.controllers;

import com.nicolas.iservice.pedidos.controllers.dto.NovoPedidoDTO;
import com.nicolas.iservice.pedidos.controllers.mappers.PedidoMapper;
import com.nicolas.iservice.pedidos.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        var pedido = mapper.map(dto);
        var novoPedido = service.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido.getCodigo());
    }
}
