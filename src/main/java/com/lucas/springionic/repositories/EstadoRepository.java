package com.lucas.springionic.repositories;

import com.lucas.springionic.domain.Cidade;
import com.lucas.springionic.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
