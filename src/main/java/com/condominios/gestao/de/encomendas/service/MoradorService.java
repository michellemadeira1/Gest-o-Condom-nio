package com.condominios.gestao.de.encomendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.condominios.gestao.de.encomendas.model.Morador;
import com.condominios.gestao.de.encomendas.repository.MoradorRepository;

@Service
public class MoradorService {

	@Autowired
	private MoradorRepository moradorRepository;

	
	
	public ResponseEntity<List<Morador>> listarMorador(String nome) {
	    List<Morador> moradores = moradorRepository.findAllByNomeContainingIgnoreCase(nome);

	    if (moradores.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(moradores);
	}

	
	public ResponseEntity<Morador> salvarMorador(Morador morador) {
		Optional<Morador> moradorExistente = moradorRepository.findByNomeAndApartamento(morador.getNome(),
				morador.getApartamento());

		if (moradorExistente.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		Morador novoMorador = moradorRepository.save(morador);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoMorador);
	}

	public ResponseEntity<Morador> buscarPorId(Long id) {
		Optional<Morador> morador = moradorRepository.findById(id);

		if (morador.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(morador.get());
	}

	public ResponseEntity<Morador> atualizarMorador(Long id, Morador moradorAtualizado) {
		Optional<Morador> moradorOptional = moradorRepository.findById(id);
		if (moradorOptional.isPresent()) {
			Morador morador = moradorOptional.get();
			morador.setApartamento(moradorAtualizado.getApartamento());
			morador.setNome(moradorAtualizado.getNome());
			morador.setTelefone(moradorAtualizado.getTelefone());
			Morador moradorAtualizadoSalvo = moradorRepository.save(morador);
			return ResponseEntity.ok(moradorAtualizadoSalvo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	public ResponseEntity<Void> deletarMorador(Long id) {
		Optional<Morador> moradorExistente = moradorRepository.findById(id);

		if (moradorExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		moradorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
