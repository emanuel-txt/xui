package com.pdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.pdv.model.Produto;
import com.pdv.service.EstoqueService;
import com.pdv.model.MovimentacaoEstoque;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
    
    @Autowired
    private EstoqueService estoqueService;
    
    @PostMapping("/movimentacao")
    public void registrarMovimentacao(@RequestBody MovimentacaoEstoque movimentacao) {
        estoqueService.registrarMovimentacao(movimentacao);
    }
    
    @GetMapping("/baixo-estoque")
    public List<Produto> listarBaixoEstoque() {
        return estoqueService.buscarProdutosBaixoEstoque();
    }
}
