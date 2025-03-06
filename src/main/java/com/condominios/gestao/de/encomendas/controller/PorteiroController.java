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

import com.condominios.gestao.de.encomendas.model.Porteiro;
import com.condominios.gestao.de.encomendas.service.PorteiroService;

@RestController
@RequestMapping("/porteiros")
public class PorteiroController {
	
	@Autowired
    private PorteiroService porteiroService;
	
	@GetMapping("/listar")
    public ResponseEntity<List<Porteiro>> listarPorteiros(Porteiro porteiro) {
        return porteiroService.listarPorteiro(porteiro);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Porteiro> buscarPorteiroPorId(@PathVariable Long id) {
        return porteiroService.buscarPorteiroPorId(id);
    }
	
	@GetMapping("/por-nome/{nome}")
    public ResponseEntity<List<Porteiro>> buscarPorteiroPorNome(@PathVariable String nome) {
        return porteiroService.buscarPorteiroPorNome(nome);
    }
	
	 @PostMapping("/cadastrar")
	    public ResponseEntity<Porteiro> salvarPorteiro(@RequestBody Porteiro porteiro) {
	        return porteiroService.salvarPorteiro(porteiro);
	    }
	 
	 @PutMapping("/atualizar/{id}")
	    public ResponseEntity<Porteiro> atualizarPorteiro(@PathVariable Long id, @RequestBody Porteiro porteiroAtualizado) {
	        return porteiroService.atualizarPorteiro(id, porteiroAtualizado);
	    }
	 
	 @DeleteMapping("/deletar/{id}")
	    public ResponseEntity<Void> deletarPorteiro(@PathVariable Long id) {
	        return porteiroService.deletarPorteiro(id);
	    }
}
