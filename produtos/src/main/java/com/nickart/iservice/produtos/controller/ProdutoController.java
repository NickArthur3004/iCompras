package com.nickart.iservice.produtos.controller;

import com.nickart.iservice.produtos.model.Produto;
import com.nickart.iservice.produtos.service.ProdutoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        return ResponseEntity.ok(service.salvar(produto));
    }

    @GetMapping
    public ResponseEntity<Produto> obterDados(@PathParam("codigo") Long codigo){
        return service
                .obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
