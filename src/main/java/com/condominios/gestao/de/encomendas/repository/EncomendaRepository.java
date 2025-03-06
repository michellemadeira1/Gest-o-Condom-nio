package com.condominios.gestao.de.encomendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominios.gestao.de.encomendas.model.Encomenda;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
    List<Encomenda> findByStatus(String status);
}