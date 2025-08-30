package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Produto produto;
    private String tipo; // ENTRADA, SAIDA, AJUSTE, DEVOLUCAO
    private Integer quantidade;
    private String motivo;
    private String responsavel;
    private LocalDateTime dataMovimentacao;
    private String numeroNota;
}
