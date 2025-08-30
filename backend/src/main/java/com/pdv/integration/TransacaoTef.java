package com.pdv.integration;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransacaoTef {
    private String nsu;
    private BigDecimal valor;
    private String status;
    private String bandeira;
    private String autorizacao;
}
