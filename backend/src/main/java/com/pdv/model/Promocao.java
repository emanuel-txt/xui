package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo; // DESCONTO_PERCENTUAL, DESCONTO_VALOR, LEVE_X_PAGUE_Y
    private Double valor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Boolean ativa;
    
    @ManyToMany
    private List<Produto> produtos;
}
