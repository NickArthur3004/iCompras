package com.nickart.iservice.produtos.service;

import com.nickart.iservice.produtos.model.Produto;

import java.util.Optional;

public interface ProdutoService {

    Produto salvar(Produto produto);

    Optional<Produto> obterPorCodigo(Long codigo);

}
