package com.condominios.gestao.de.encomendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominios.gestao.de.encomendas.model.Porteiro;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro, Long> {
	
	 List<Porteiro> findByNomeContainingIgnoreCase(String nome);
}
