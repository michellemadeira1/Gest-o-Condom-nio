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

import com.condominios.gestao.de.encomendas.model.Morador;
import com.condominios.gestao.de.encomendas.service.MoradorService;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

	@Autowired
	private MoradorService moradorService;

	@GetMapping("/por-nome/{nome}")
	public ResponseEntity<List<Morador>> listarMoradores(@PathVariable String nome) {
		return moradorService.listarMorador(nome);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Morador> buscarPorId(@PathVariable Long id) {
		return moradorService.buscarPorId(id);
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Morador> salvarMorador(@RequestBody Morador morador) {
		return moradorService.salvarMorador(morador);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Morador> atualizarMorador(@PathVariable Long id, @RequestBody Morador moradorAtualizado) {
		return moradorService.atualizarMorador(id, moradorAtualizado);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarMorador(@PathVariable Long id) {
		return moradorService.deletarMorador(id);
	}
}
