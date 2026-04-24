package com.nickart.iservice.clientes.services.impl;

import com.nickart.iservice.clientes.model.Cliente;
import com.nickart.iservice.clientes.repositories.ClienteRepository;
import com.nickart.iservice.clientes.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repositoryepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        return repositoryepository.save(cliente);
    }

    @Override
    public Optional<Cliente> obterPorCodigo(Long codigo) {
        return repositoryepository.findById(codigo);
    }
}
