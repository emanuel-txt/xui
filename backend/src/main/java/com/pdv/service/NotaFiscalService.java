package com.pdv.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pdv.model.NotaFiscal;
import com.pdv.model.Venda;
import com.pdv.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {
    @Autowired
    private NotaFiscalRepository notaFiscalRepository;
    
    @Transactional
    public NotaFiscal emitirNFCe(Venda venda) {
        NotaFiscal nf = new NotaFiscal();
        nf.setVenda(venda);
        nf.setDataEmissao(LocalDateTime.now());
        // Lógica de integração com SEFAZ
        return notaFiscalRepository.save(nf);
    }
    
    public String gerarXML(NotaFiscal nf) {
        String xml = "<?xml version=\"1.0\"?>"; // Implementar geração real
        return xml;
    }
}
