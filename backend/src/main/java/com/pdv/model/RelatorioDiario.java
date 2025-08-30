package com.pdv.model;

import lombok.Data;
import java.time.LocalDate;
import java.math.BigDecimal;

@Data
public class RelatorioDiario {
    private LocalDate data;
    private BigDecimal totalVendas;
    private Integer quantidadeVendas;
    private BigDecimal ticketMedio;
}
