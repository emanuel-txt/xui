package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String endereco;
    private LocalDate dataNascimento;
    private Double limiteCredito;
    private Integer pontosFidelidade;
    private String grupo;
    private Boolean ativo;
}
