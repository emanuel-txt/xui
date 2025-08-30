package com.pdv.controller;

import com.pdv.model.Venda;
import com.pdv.model.ItemVenda;
import com.pdv.model.Pagamento;
import com.pdv.model.RelatorioDiario;
import com.pdv.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    
    @Autowired
    private VendaService vendaService;
    
    @PostMapping
    public Venda realizarVenda(@RequestBody Venda venda) {
        return vendaService.realizarVenda(venda);
    }
    
    @PostMapping("/{id}/devolucao")
    public Venda processarDevolucao(@PathVariable Long id, @RequestBody ItemVenda item) {
        return vendaService.processarDevolucao(id, item);
    }
    
    @PostMapping("/{id}/pagamento")
    public Venda registrarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return vendaService.registrarPagamento(id, pagamento);
    }
    
    @GetMapping("/relatorio/diario")
    public RelatorioDiario gerarRelatorioDiario(@RequestParam LocalDate data) {
        return vendaService.gerarRelatorioDiario(data);
    }
}
