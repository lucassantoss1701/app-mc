package com.lucas.springionic.resources;
import com.lucas.springionic.domain.Cliente;
import com.lucas.springionic.domain.Cliente;
import com.lucas.springionic.dto.ClienteDTO;
import com.lucas.springionic.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> listar(@PathVariable Integer id){
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){
        Cliente obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj ->new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value ="/page")
    public ResponseEntity<Page> findPage(@RequestParam(value = "page", defaultValue = "0")  Integer page,
                                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                         @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDTO = list.map(obj ->new ClienteDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }
}
