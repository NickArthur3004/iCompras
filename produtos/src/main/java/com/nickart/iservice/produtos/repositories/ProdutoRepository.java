package com.nickart.iservice.produtos.repositories;

import com.nickart.iservice.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
