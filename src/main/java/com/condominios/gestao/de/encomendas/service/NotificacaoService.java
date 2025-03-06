package com.condominios.gestao.de.encomendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.condominios.gestao.de.encomendas.model.Notificacao;
import com.condominios.gestao.de.encomendas.repository.NotificacaoRepository;

@Service
public class NotificacaoService {
	
	 @Autowired
	 private NotificacaoRepository notificacaoRepository;
	 
	// Listar notificações por nome de morador
	 public ResponseEntity<List<Notificacao>> listarNotificacoesPorNome(String nome) {
	        List<Notificacao> notificacoes = notificacaoRepository.findByEncomenda_Morador_NomeContainingIgnoreCase(nome);

	        if (notificacoes.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(notificacoes);
	    }
	 
	 
	 public ResponseEntity<List<Notificacao>> listarNotificacoesPorStatus(Boolean statusEnvio) {
	        List<Notificacao> notificacoes = notificacaoRepository.findByStatusEnvio(statusEnvio);

	        if (notificacoes.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(notificacoes);
	    }

	 public ResponseEntity<Notificacao> salvarNotificacao(Notificacao notificacao) {
		 if (notificacao.getId() != null && notificacaoRepository.findById(notificacao.getId()).isPresent()) {
	            return ResponseEntity.status(HttpStatus.CONFLICT).build();
	        }

		 Notificacao novoNotificacao = notificacaoRepository.save(notificacao);
	        return ResponseEntity.ok(novoNotificacao);  
	    }
	 
	 
	 public ResponseEntity<Notificacao> buscarPorId(Long id) {
	        Optional<Notificacao> notificacao = notificacaoRepository.findById(id);

	        if (notificacao.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(notificacao.get());
	    }
	 
	 
	  public ResponseEntity<Notificacao> atualizarNotificacao(Long id, Notificacao notificacaoAtualizada) {
	        Optional<Notificacao> notificacaoExistente = notificacaoRepository.findById(id);
	        if (notificacaoExistente.isPresent()) {
	        Notificacao notificacao = notificacaoExistente.get();
	        notificacao.setStatusEnvio(notificacaoAtualizada.getStatusEnvio());
	        notificacao.setDataEnvio(notificacaoAtualizada.getDataEnvio());
	        notificacao.setMenssagem(notificacaoAtualizada.getMenssagem());
	        Notificacao notificacaoAtualizadaSalva = notificacaoRepository.save(notificacao);
	        return ResponseEntity.ok(notificacaoAtualizadaSalva);
	        }else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
	        }
	    }
	 
	  public ResponseEntity<Void> deletarNotificacao(Long id) {
	        Optional<Notificacao> notificacaoExistente = notificacaoRepository.findById(id);

	        if (notificacaoExistente.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        notificacaoRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	 
}
