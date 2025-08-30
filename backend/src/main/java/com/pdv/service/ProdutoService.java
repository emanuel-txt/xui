package com.pdv.service;

import com.pdv.model.Produto;
import com.pdv.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> getCatalogo() {
        return produtoRepository.findAll();
    }
}
