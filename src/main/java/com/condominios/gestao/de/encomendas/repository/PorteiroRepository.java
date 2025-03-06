package com.condominios.gestao.de.encomendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominios.gestao.de.encomendas.model.Porteiro;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro, Long> {
}
