package com.jalautopecas.models;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

@Entity
public class Vendedor {

	@Id
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Length(min=2, max=30,message="O tamanho do nome deve ser entre {min} e {max} caracteres")
	private String nome;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<CotacaoDeProduto> cotacoes;
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
	
	public List<CotacaoDeProduto> getCotacoes() {
		return cotacoes;
	}
	public void setCotacoes(List<CotacaoDeProduto> cotacoes) {
		this.cotacoes = cotacoes;
	}
	public Vendedor(Long id, @NotNull String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Vendedor() {
		
	}
	
	
}
