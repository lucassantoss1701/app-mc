package com.lucas.springionic.resources;
import com.lucas.springionic.domain.Categoria;
import com.lucas.springionic.domain.Cliente;
import com.lucas.springionic.domain.Pedido;
import com.lucas.springionic.dto.CategoriaDTO;
import com.lucas.springionic.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> listar(@PathVariable Integer id){
        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
