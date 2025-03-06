package com.condominios.gestao.de.encomendas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Morador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String apartamento;

	@NotNull
	private String telefone;

	@OneToMany(mappedBy = "morador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Encomenda> encomendas = new ArrayList<>();

	public Morador() {
	}

	public Morador(Long id, @NotNull String nome, @NotNull String apartamento, @NotNull String telefone) {
		this.id = id;
		this.nome = nome;
		this.apartamento = apartamento;
		this.telefone = telefone;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
