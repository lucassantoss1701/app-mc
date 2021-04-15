package com.lucas.springionic.repositories;

import com.lucas.springionic.domain.Categoria;
import com.lucas.springionic.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
