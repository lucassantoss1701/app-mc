package com.lucas.springionic.services;

import com.lucas.springionic.domain.Categoria;
import com.lucas.springionic.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Optional<Categoria> buscar(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj;
    }
}
