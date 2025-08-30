package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class MovimentacaoCaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; // ENTRADA, SAIDA, SANGRIA, SUPRIMENTO
    private Double valor;
    private String descricao;
    private LocalDateTime dataMovimentacao;
    private String responsavel;
}
