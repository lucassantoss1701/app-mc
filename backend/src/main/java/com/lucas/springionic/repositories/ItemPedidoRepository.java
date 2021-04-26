package com.lucas.springionic.repositories;

import com.lucas.springionic.domain.Categoria;
import com.lucas.springionic.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
