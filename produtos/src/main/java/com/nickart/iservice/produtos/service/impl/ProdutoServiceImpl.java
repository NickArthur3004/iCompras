package com.nickart.iservice.produtos.service.impl;

import com.nickart.iservice.produtos.model.Produto;
import com.nickart.iservice.produtos.repositories.ProdutoRepository;
import com.nickart.iservice.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;


    @Override
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Optional<Produto> obterPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }


}
