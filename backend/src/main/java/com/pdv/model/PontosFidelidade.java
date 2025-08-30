package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class PontosFidelidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Cliente cliente;
    private Integer pontos;
    private String tipo; // CREDITO, DEBITO
    private LocalDateTime dataExpiracao;
    private String origem; // COMPRA, BONUS, PROMOCAO
}
