package com.pdv.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String codigoBarras;
    private String nome;
    private String descricao;
    private Double preco;
    private Double precoAtacado;
    private Double custoMedio;
    private Double margemLucro;
    private Integer estoque;
    private Integer estoqueMinimo;
    private Integer estoqueMaximo;
    private String unidadeMedida;
    private String ncm;
    private String localizacao;
    private Boolean ativo;
    private LocalDateTime validade;
    private String categoria;
    private String fornecedor;
    private String urlImagem;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> grades;
}
