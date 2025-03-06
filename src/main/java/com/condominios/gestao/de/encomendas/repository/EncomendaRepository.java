package com.condominios.gestao.de.encomendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condominios.gestao.de.encomendas.model.Encomenda;
import com.condominios.gestao.de.encomendas.model.Morador;
import com.condominios.gestao.de.encomendas.model.Porteiro;
import com.condominios.gestao.de.encomendas.model.StatusEncomenda;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
	List<Encomenda> findAllByMoradorNomeContainingIgnoreCase(String nomeMorador);
	Optional<Encomenda> findByMoradorAndPorteiroAndStatus(Morador morador, Porteiro porteiro, StatusEncomenda status);
    List<Encomenda> findByStatus(StatusEncomenda status);
}