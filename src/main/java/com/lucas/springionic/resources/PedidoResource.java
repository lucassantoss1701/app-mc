package com.lucas.springionic.resources;
import com.lucas.springionic.domain.Pedido;
import com.lucas.springionic.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Pedido obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
