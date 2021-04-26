package com.lucas.springionic.repositories;

import com.lucas.springionic.domain.Cliente;
import com.lucas.springionic.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
