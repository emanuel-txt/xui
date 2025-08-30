package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Produto produto;
    
    private Integer quantidade;
    private Double precoUnitario;
    private Double subtotal;
    private Double desconto;
    private Boolean devolvido;
    private String motivoDevolucao;
    private LocalDateTime dataDevolucao;
    
    private String cfop;
    private String ncm;
    private Double valorIcms;
    private Double aliquotaIcms;
    private String cst;
    
    @PrePersist
    public void calcularSubtotal() {
        this.subtotal = (this.precoUnitario * this.quantidade) - (this.desconto != null ? this.desconto : 0.0);
    }
    
    @PrePersist
    public void calcularImpostos() {
        // Cálculo de impostos
        this.valorIcms = (this.subtotal * this.aliquotaIcms) / 100;
    }
}
