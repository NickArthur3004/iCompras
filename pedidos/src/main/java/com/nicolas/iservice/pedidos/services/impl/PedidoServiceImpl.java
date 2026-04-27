package com.nicolas.iservice.pedidos.services.impl;

import com.nicolas.iservice.pedidos.model.Pedido;
import com.nicolas.iservice.pedidos.repositories.ItemPedidoRepositoy;
import com.nicolas.iservice.pedidos.repositories.PedidoRepository;
import com.nicolas.iservice.pedidos.services.PedidoService;
import com.nicolas.iservice.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepositoy itemPedidoRepositoy;
    private final PedidoValidator pedidoValidator;

    public Pedido criarPedido(Pedido pedido){
        repository.save(pedido);
        itemPedidoRepositoy.saveAll(pedido.getItens());
        return pedido;
    }
}
