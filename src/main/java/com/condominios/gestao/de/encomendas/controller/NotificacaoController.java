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

import com.condominios.gestao.de.encomendas.model.Notificacao;
import com.condominios.gestao.de.encomendas.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

	@Autowired
	private NotificacaoService notificacaoService;

	@GetMapping("/por-nome/{nome}")
    public ResponseEntity<List<Notificacao>> listarNotificacoesPorNome(@PathVariable String nome) {
        return notificacaoService.listarNotificacoesPorNome(nome);
    }
	@GetMapping("/por-status/{statusEnvio}")
	public ResponseEntity<List<Notificacao>> listarNotificacoesPorStatus(@PathVariable Boolean statusEnvio) {
		return notificacaoService.listarNotificacoesPorStatus(statusEnvio);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Notificacao> buscarPorId(@PathVariable Long id) {
		return notificacaoService.buscarPorId(id);
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Notificacao> salvarNotificacao(@RequestBody Notificacao notificacao) {
		return notificacaoService.salvarNotificacao(notificacao);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Notificacao> atualizarNotificacao(@PathVariable Long id,
			@RequestBody Notificacao notificacaoAtualizada) {
		return notificacaoService.atualizarNotificacao(id, notificacaoAtualizada);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarNotificacao(@PathVariable Long id) {
		return notificacaoService.deletarNotificacao(id);
	}
}
