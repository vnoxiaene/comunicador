package com.jalautopecas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class CotacaoDeProduto {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private	Long	id;
	@NotNull
	@Length(min=2,	max=30,message=	"O	tamanho	da descrição deve ser entre	{min}	e	{max}	caracteres") 
	private String descricao;
	@NotNull
	@Length(min=2,	max=30,message=	"O	tamanho do veiculo	deve ser entre	{min}	e	{max}	caracteres") 
	private String veiculo;
	@NotNull
	@Length(min=2,	max=30,message=	"O	tamanho	do modelo de carro deve ser	entre	{min}	e	{max}	caracteres") 
	private String modeloCarro;
	@NotNull
	@Length(min=2,	max=30,message=	"O campo Ano deve ser	entre	{min}	e	{max}	caracteres") 
	private String anoCarro;
	@ManyToOne
	@NotNull(message= "O campo vendedor não pode ser nulo")
	private Vendedor vendedor;
	private String chassi;
	private String referencia;
	private String observacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public String getAnoCarro() {
		return anoCarro;
	}
	public void setAnoCarro(String anoCarro) {
		this.anoCarro = anoCarro;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public CotacaoDeProduto() {
	}
	public CotacaoDeProduto(Long id, @NotNull String descricao, @NotNull String veiculo, @NotNull String modeloCarro,
			@NotNull String anoCarro, String chassi, String referencia, String observacao, @NotNull Vendedor vendedor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.veiculo = veiculo;
		this.modeloCarro = modeloCarro;
		this.anoCarro = anoCarro;
		this.chassi = chassi;
		this.referencia = referencia;
		this.observacao = observacao;
		this.vendedor = vendedor;
	}
	
	

}
