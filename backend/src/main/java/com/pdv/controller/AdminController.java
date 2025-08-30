package com.pdv.controller;

import com.pdv.model.Produto;
import com.pdv.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @PutMapping("/produtos/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return adminService.atualizarProduto(id, produto);
    }
    
    @DeleteMapping("/produtos/{id}")
    public void deletarProduto(@PathVariable Long id) {
        adminService.deletarProduto(id);
    }
}
