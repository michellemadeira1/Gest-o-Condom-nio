package com.condominios.gestao.de.encomendas.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Notificacao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataEnvio;
	private Boolean statusEnvio;
	private String menssagem;
	
	
	@ManyToOne
	@JoinColumn(name = "encomenda_id", nullable = false)
    private Encomenda encomenda;
	
	public Notificacao() {}
	
	public Notificacao(Long id, LocalDateTime dataEnvio, Boolean statusEnvio, String menssagem) {
		super();
		this.id = id;
		this.dataEnvio = dataEnvio;
		this.statusEnvio = statusEnvio;
		this.menssagem = menssagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Boolean getStatusEnvio() {
		return statusEnvio;
	}

	public void setStatusEnvio(Boolean statusEnvio) {
		this.statusEnvio = statusEnvio;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}
	
	
	
}
