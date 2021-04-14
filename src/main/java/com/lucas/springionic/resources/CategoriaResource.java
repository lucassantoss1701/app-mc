package com.lucas.springionic.resources;
import com.lucas.springionic.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @GetMapping
    public String listar(){
        List<Categoria> lista;
        return "uaa";
    }
}
