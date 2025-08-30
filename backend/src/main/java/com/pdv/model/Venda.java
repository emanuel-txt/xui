package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataVenda;
    private Double valorTotal;
    private String status;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemVenda> itens;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;
    
    @ManyToOne
    private Cliente cliente;
    
    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
