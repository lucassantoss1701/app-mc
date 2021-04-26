package com.lucas.springionic.dto;

import com.lucas.springionic.domain.Produto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProdutoDTO {

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(){

    }

    public ProdutoDTO(Produto obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
