package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Venda venda;
    private String status;
    private String endereco;
    private String telefone;
    private Double taxaEntrega;
    private String entregador;
    private LocalDateTime previsaoEntrega;
}
