package com.nickart.iservice.clientes.services;

import com.nickart.iservice.clientes.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente salvar(Cliente cliente);

    Optional<Cliente> obterPorCodigo(Long codigo);
}
