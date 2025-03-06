package com.condominios.gestao.de.encomendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.condominios.gestao.de.encomendas.model.Porteiro;
import com.condominios.gestao.de.encomendas.repository.PorteiroRepository;

@Service
public class PorteiroService {

	 @Autowired
	 private PorteiroRepository porteiroRepository;
	 
	 
	 public ResponseEntity<List<Porteiro>> listarPorteiro(Porteiro porteiro){
	        List<Porteiro> porteiroExistentes = porteiroRepository.findByNomeContainingIgnoreCase(porteiro.getNome());
	        
	        if(porteiroExistentes.isEmpty()) {
	            return ResponseEntity.noContent().build(); 
	        } else {
	            return ResponseEntity.ok(porteiroExistentes);  
	        }
	    }
	 
	 public ResponseEntity<Porteiro> salvarPorteiro(Porteiro porteiro) {
	        if (porteiro.getId() != null && porteiroRepository.findById(porteiro.getId()).isPresent()) {
	            return ResponseEntity.status(HttpStatus.CONFLICT).build();
	        }

	        Porteiro novoPorteiro = porteiroRepository.save(porteiro);
	        return ResponseEntity.ok(novoPorteiro);  
	    }
	 
	 public ResponseEntity<Porteiro> buscarPorteiroPorId(Long id) {
	        Optional<Porteiro> porteiro = porteiroRepository.findById(id);

	        if (porteiro.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	        return ResponseEntity.ok(porteiro.get());
	    }
	 
	 public ResponseEntity<List<Porteiro>> buscarPorteiroPorNome(String nome) {
	        List<Porteiro> porteiros = porteiroRepository.findByNomeContainingIgnoreCase(nome);
	        if (porteiros.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.ok(porteiros);
	    }
	 
	 public ResponseEntity<Porteiro> atualizarPorteiro(Long id, Porteiro porteiroAtualizado) {
	        Optional<Porteiro> porteiroOptional = porteiroRepository.findById(id);
	        if (porteiroOptional.isPresent()) {
	            Porteiro porteiro = porteiroOptional.get();
	            porteiro.setNome(porteiroAtualizado.getNome());
	            porteiro.setEmail(porteiroAtualizado.getEmail());
	            Porteiro porteiroAtualizadoSalvo = porteiroRepository.save(porteiro);
	            return ResponseEntity.ok(porteiroAtualizadoSalvo);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	 
	 public ResponseEntity<Void> deletarPorteiro(Long id) {
	        Optional<Porteiro> porteiroExistente = porteiroRepository.findById(id);
	        if (porteiroExistente.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        porteiroRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
