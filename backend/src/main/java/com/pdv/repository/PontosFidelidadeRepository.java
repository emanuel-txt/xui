package com.pdv.repository;

import com.pdv.model.PontosFidelidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontosFidelidadeRepository extends JpaRepository<PontosFidelidade, Long> {
}
