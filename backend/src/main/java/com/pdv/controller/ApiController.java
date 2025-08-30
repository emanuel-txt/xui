package com.pdv.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.pdv.model.Produto;
import com.pdv.model.Venda;
import com.pdv.model.SyncRequest;
import com.pdv.service.VendaService;
import com.pdv.service.ProdutoService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    private VendaService vendaService;
    
    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping("/vendas/sync")
    public List<Venda> sincronizarVendas(@RequestBody SyncRequest request) {
        return vendaService.sincronizar(request);
    }
    
    @GetMapping("/catalogo")
    public List<Produto> getCatalogo() {
        return produtoService.getCatalogo();
    }
}
}
    }
}
