package com.pdv.service;

import com.pdv.model.Produto;
import com.pdv.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto atualizarProduto(Long id, Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }
    
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
    
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }
    
    public void importarProdutos(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
    }
    
    public Map<String, Object> getDashboard() {
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalProdutos", produtoRepository.count());
        dashboard.put("produtosBaixoEstoque", produtoRepository.countByEstoqueLessThanEstoqueMinimo());
        return dashboard;
    }
}
