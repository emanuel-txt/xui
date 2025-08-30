package com.pdv.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SyncRequest {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String filial;
}
