package com.condominios.gestao.de.encomendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominios.gestao.de.encomendas.model.Encomenda;
import com.condominios.gestao.de.encomendas.model.StatusEncomenda;
import com.condominios.gestao.de.encomendas.service.EncomendaService;

@RestController
@RequestMapping("/encomendas")
public class EncomendaController {

	@Autowired
	private EncomendaService encomendaService;

	@GetMapping("/por-morador/{nomeMorador}")
	public ResponseEntity<List<Encomenda>> listarEncomendasPorNome(@PathVariable String nomeMorador) {
		return encomendaService.listarEncomendasPorNome(nomeMorador);
	}

	@GetMapping("/por-status/{status}")
	public ResponseEntity<List<Encomenda>> listarEncomendasPorStatus(@PathVariable StatusEncomenda status) {
		return encomendaService.listarEncomendasPorStatus(status);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Encomenda> buscarPorId(@PathVariable Long id) {
		return encomendaService.buscarPorId(id);
	}
	
	@PostMapping("/cadastrar")
    public ResponseEntity<Encomenda> salvarEncomenda(@RequestBody Encomenda encomenda) {
        return encomendaService.salvarEncomenda(encomenda);
    }
	
	@PutMapping("/atualizar/{id}")
    public ResponseEntity<Encomenda> atualizarEncomenda(@PathVariable Long id, @RequestBody Encomenda encomendaAtualizada) {
        return encomendaService.atualizarEncomenda(id, encomendaAtualizada);
    }
	
	@DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEncomenda(@PathVariable Long id) {
        return encomendaService.deletarEncomenda(id);
    }
}
