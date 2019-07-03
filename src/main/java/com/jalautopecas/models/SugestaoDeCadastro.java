package com.jalautopecas.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SugestaoDeCadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String veiculo;
	private String modelo;
	private String descricao;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date datadeabertura;
	private String ano;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@ManyToOne
	private Vendedor vendedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDatadeabertura() {
		return datadeabertura;
	}

	public void setDatadeabertura(Date datadeabertura) {
		this.datadeabertura = datadeabertura;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public SugestaoDeCadastro(Long id, String veiculo, String modelo, String descricao, String ano, Vendedor vendedor) {
		this.id = id;
		this.veiculo = veiculo;
		this.modelo = modelo;
		this.descricao = descricao;
		this.datadeabertura = new Date();
		this.ano = ano;
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "SugestaoDeCadastro [id=" + id + ", veiculo=" + veiculo + ", modelo=" + modelo + ", descricao="
				+ descricao + ", datadeabertura=" + datadeabertura + ", vendedor=" + vendedor + "]";
	}

	public SugestaoDeCadastro() {
	}
}
