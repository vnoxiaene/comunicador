package com.jalautopecas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class PrecoConcorrencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Produto> produtos;
	private String concorrente;
	private Date datadeabertura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getConcorrente() {
		return concorrente;
	}

	public void setConcorrente(String concorrente) {
		this.concorrente = concorrente;
	}

	public Date getDatadeabertura() {
		return datadeabertura;
	}

	public void setDatadeabertura(Date datadeabertura) {
		this.datadeabertura = datadeabertura;
	}

	public PrecoConcorrencia(Long id, List<Produto> produtos, String concorrente, Date datadeabertura) {
		this.id = id;
		this.produtos = produtos;
		this.concorrente = concorrente;
		this.datadeabertura = datadeabertura;
	}

	public PrecoConcorrencia() {
		// TODO Auto-generated constructor stub
	}

}
