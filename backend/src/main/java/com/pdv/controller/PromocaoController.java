package com.pdv.controller;

import com.pdv.model.Promocao;
import com.pdv.model.Venda;
import com.pdv.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/promocoes")
public class PromocaoController {
    
    @Autowired
    private PromocaoService promocaoService;
    
    @PostMapping
    public Promocao criar(@RequestBody Promocao promocao) {
        return promocaoService.salvar(promocao);
    }
    
    @GetMapping("/ativas")
    public List<Promocao> listarAtivas() {
        return promocaoService.buscarAtivas();
    }
    
    @PostMapping("/{id}/aplicar")
    public Venda aplicarPromocao(@PathVariable Long id, @RequestBody Venda venda) {
        return promocaoService.aplicarPromocao(id, venda);
    }
}
