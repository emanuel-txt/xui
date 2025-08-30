package com.pdv.service;

import com.pdv.model.Produto;
import com.pdv.model.Venda;
import com.pdv.model.SyncRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdv.model.ItemVenda;
import com.pdv.model.Pagamento;
import com.pdv.model.PontosFidelidade;
import com.pdv.model.RelatorioDiario;

import com.pdv.repository.ProdutoRepository;
import com.pdv.repository.PontosFidelidadeRepository;
import com.pdv.repository.VendaRepository;

@Service
public class VendaService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private PontosFidelidadeRepository pontosFidelidadeRepository;
    
    @Autowired
    private VendaRepository vendaRepository;
    
    @Transactional
    public Venda realizarVenda(Venda venda) {
        venda.getItens().forEach(item -> {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            produto.setEstoque(produto.getEstoque() - item.getQuantidade());
            produtoRepository.save(produto);
        });
        
        venda.setDataVenda(LocalDateTime.now());
        venda.setStatus("CONCLUIDA");
        
        if (venda.getCliente() != null) {
            PontosFidelidade pontos = new PontosFidelidade();
            pontos.setCliente(venda.getCliente());
            pontos.setPontos((int)(venda.getValorTotal() / 10)); // 1 ponto a cada R$ 10
            pontos.setTipo("CREDITO");
            pontos.setOrigem("COMPRA");
            pontos.setDataExpiracao(LocalDateTime.now().plusMonths(6));
            pontosFidelidadeRepository.save(pontos);
        }
        
        return vendaRepository.save(venda);
    }
    
    @Transactional
    public Venda processarDevolucao(Long id, ItemVenda item) {
        Venda venda = vendaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
            
        item.setDevolvido(true);
        item.setDataDevolucao(LocalDateTime.now());
        
        Produto produto = item.getProduto();
        produto.setEstoque(produto.getEstoque() + item.getQuantidade());
        produtoRepository.save(produto);
        
        return vendaRepository.save(venda);
    }
    
    public Venda registrarPagamento(Long id, Pagamento pagamento) {
        Venda venda = vendaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        venda.setPagamento(pagamento);
        return vendaRepository.save(venda);
    }
    
    public RelatorioDiario gerarRelatorioDiario(LocalDate data) {
        RelatorioDiario relatorio = new RelatorioDiario();
        relatorio.setData(data);
        // Implementar lógica do relatório
        return relatorio;
    }
    
    public List<Venda> sincronizar(SyncRequest request) {
        // Implementar lógica de sincronização
        return vendaRepository.findByDataVendaBetween(
            request.getDataInicio(), 
            request.getDataFim()
        );
    }
}
