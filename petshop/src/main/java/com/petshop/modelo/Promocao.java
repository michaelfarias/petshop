package com.petshop.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.petshop.modelo.enums.StatusPromocao;

@Entity
public class Promocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private double preco;
	private Integer status;

	@OneToMany
	private List<Servico> servicos;

	public Promocao() {

	}

	public Promocao(String nome, double preco, Integer status) {
		this.nome = nome;
		this.preco = preco;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public StatusPromocao getStatus() {
		return StatusPromocao.toEnum(this.status);
	}

	public void setStatus(StatusPromocao status) {
		this.status = status.getCod();
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
