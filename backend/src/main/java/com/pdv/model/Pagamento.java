package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private String formaPagamento;
    private LocalDateTime dataPagamento;
    private String status;
    
    @ManyToOne
    private Venda venda;
}
