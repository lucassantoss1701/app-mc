package com.lucas.springionic.services;

import com.lucas.springionic.domain.Categoria;
import com.lucas.springionic.dto.CategoriaDTO;
import com.lucas.springionic.repositories.CategoriaRepository;
import com.lucas.springionic.services.exceptions.DataIntegrityException;
import com.lucas.springionic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj){
        Categoria newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void deleteById(Integer id){
        find(id);

        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO categoriaDTO){
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }

    private void updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
    }
}