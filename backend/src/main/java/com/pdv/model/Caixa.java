package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private Double saldoInicial;
    private Double saldoFinal;
    private String status;
    private String operador;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<MovimentacaoCaixa> movimentacoes;
}
