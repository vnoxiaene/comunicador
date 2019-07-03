package com.jalautopecas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigojal;
	private String descricao;

	@ManyToMany
	private List<PrecoProduto> precos;

	private String marca;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String codigojal, String descricao, List<PrecoProduto> precos, String marca) {
		this.codigojal = codigojal;
		this.descricao = descricao;
		this.precos = precos;
		this.marca = marca;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigojal() {
		return codigojal;
	}

	public void setCodigojal(String codigojal) {
		this.codigojal = codigojal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
