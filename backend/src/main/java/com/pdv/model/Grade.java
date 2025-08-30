package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho;
    private String cor;
    private Integer estoque;
    private String codigo;
}
