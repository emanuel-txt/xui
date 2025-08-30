package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String serie;
    private String chaveAcesso;
    private String xml;
    private LocalDateTime dataEmissao;
    private String status;
    
    @OneToOne
    private Venda venda;
}
