package com.condominios.gestao.de.encomendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominios.gestao.de.encomendas.model.Morador;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {
	List<Morador> findAllByNomeContainingIgnoreCase(String nome);
	
	Optional<Morador> findByNomeAndApartamento(String nome, String apartamento);

}
