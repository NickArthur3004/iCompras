package com.nicolas.iservice.pedidos.client;

import com.nicolas.iservice.pedidos.client.representation.ClienteRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "clientes", url = "${icompras.pedidos.clients.clientes.url}")
public interface ClientesClient {

    @GetMapping
    ResponseEntity<ClienteRepresentation> obterDados(@RequestParam("codigo") Long codigo);
}
