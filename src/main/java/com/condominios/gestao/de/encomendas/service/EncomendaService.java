package com.condominios.gestao.de.encomendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.condominios.gestao.de.encomendas.model.Encomenda;

import com.condominios.gestao.de.encomendas.model.StatusEncomenda;
import com.condominios.gestao.de.encomendas.repository.EncomendaRepository;

@Service
public class EncomendaService {
	
	@Autowired
    private EncomendaRepository encomendaRepository;
	
	// Listar encomendas por nome do morador
	 public ResponseEntity<List<Encomenda>> listarEncomendasPorNome(String nomeMorador) {
	        List<Encomenda> encomendas = encomendaRepository.findAllByMoradorNomeContainingIgnoreCase(nomeMorador);

	        if (encomendas.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(encomendas);
	    }
	 
	 
	 public ResponseEntity<List<Encomenda>> listarEncomendasPorStatus(StatusEncomenda status) {
	        List<Encomenda> encomendas = encomendaRepository.findByStatus(status);

	        if (encomendas.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(encomendas);
	    }
	 
	 public ResponseEntity<Encomenda> salvarEncomenda(Encomenda encomenda) {
		    Optional<Encomenda> encomendaExistente = encomendaRepository
		            .findByMoradorAndPorteiroAndStatus(encomenda.getMorador(), encomenda.getPorteiro(), encomenda.getStatus());

		    if (encomendaExistente.isPresent()) {
		        return ResponseEntity.status(HttpStatus.CONFLICT).build(); 
		    }
		    Encomenda novaEncomenda = encomendaRepository.save(encomenda);
		    return ResponseEntity.status(HttpStatus.CREATED).body(novaEncomenda);
		}

	 
	 public ResponseEntity<Encomenda> buscarPorId(Long id) {
	        Optional<Encomenda> encomenda = encomendaRepository.findById(id);

	        if (encomenda.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(encomenda.get());
	    }
	 
	 
	 public ResponseEntity<Encomenda> atualizarEncomenda(Long id, Encomenda encomendaAtualizada) {
		    Optional<Encomenda> encomendaOptional = encomendaRepository.findById(id);
		    
		    if (encomendaOptional.isPresent()) {
		        Encomenda encomenda = encomendaOptional.get();
		        encomenda.setDescricao(encomendaAtualizada.getDescricao());
		        encomenda.setDataRecebimento(encomendaAtualizada.getDataRecebimento());
		        encomenda.setStatus(encomendaAtualizada.getStatus());
		        encomenda.setMorador(encomendaAtualizada.getMorador());
		        encomenda.setPorteiro(encomendaAtualizada.getPorteiro());
		        Encomenda encomendaAtualizadaSalva = encomendaRepository.save(encomenda);
		        return ResponseEntity.ok(encomendaAtualizadaSalva);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }
		}

	 
	 public ResponseEntity<Void> deletarEncomenda(Long id) {
	        Optional<Encomenda> encomendaExistente = encomendaRepository.findById(id);

	        if (encomendaExistente.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        encomendaRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
