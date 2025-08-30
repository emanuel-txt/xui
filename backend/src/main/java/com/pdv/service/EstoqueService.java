package com.pdv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdv.model.*;
import com.pdv.repository.*;

import java.util.List;

@Service
public class EstoqueService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoRepository;

    @Transactional
    public void registrarMovimentacao(MovimentacaoEstoque mov) {
        Produto produto = produtoRepository.findById(mov.getProduto().getId())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            
        if (mov.getTipo().equals("ENTRADA")) {
            produto.setEstoque(produto.getEstoque() + mov.getQuantidade());
        } else if (mov.getTipo().equals("SAIDA")) {
            if (produto.getEstoque() < mov.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente");
            }
            produto.setEstoque(produto.getEstoque() - mov.getQuantidade());
        }
        
        produtoRepository.save(produto);
        movimentacaoRepository.save(mov);
    }

    public void verificarEstoqueMinimo() {
        List<Produto> produtosBaixoEstoque = produtoRepository
            .findByEstoqueLessThanEstoqueMinimo();
            
        // Lógica para notificação de estoque baixo
    }
    
    public List<Produto> buscarProdutosBaixoEstoque() {
        return produtoRepository.findByEstoqueLessThanEstoqueMinimo();
    }
}
