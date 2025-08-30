package com.pdv.service;

import com.pdv.model.Promocao;
import com.pdv.model.Venda;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromocaoService {
    public Promocao salvar(Promocao promocao) {
        return promocao;
    }
    
    public List<Promocao> buscarAtivas() {
        return List.of();
    }
    
    public Venda aplicarPromocao(Long id, Venda venda) {
        return venda;
    }
}
