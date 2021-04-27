package com.lucas.springionic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(){

    }

    public Pedido(Integer id, Date instant, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instant = instant;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public double getValorTotal(){
        double soma = 0.0;
        for(ItemPedido ip : itens){
            soma = soma + ip.getSubTotal();
        }
        return soma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        final StringBuilder sb = new StringBuilder();
        sb.append("Pedido número: ");
        sb.append(getId());
        sb.append(", Instante: ");
        sb.append(sdf.format(getInstant()));
        sb.append(", Cliente: ");
        sb.append(getCliente().getNome());
        sb.append(", Situação do pagamento: ");
        sb.append(getPagamento().getEstado().getDescricao());
        sb.append("\nDetalhes\n");
        for (ItemPedido ip : getItens()){
            sb.append(ip.toString());
        }
        sb.append("Valor total: ");
        sb.append(nf.format(getValorTotal()));
        sb.append("\n");
        return sb.toString();
    }

}
