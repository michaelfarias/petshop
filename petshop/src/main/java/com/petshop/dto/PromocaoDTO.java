package com.petshop.dto;

import com.petshop.modelo.Promocao;
import com.petshop.modelo.enums.StatusPromocao;

public class PromocaoDTO {

	private Integer id;

	private String nome;
	private double preco;
	private Integer status;

	public PromocaoDTO() {
	}

	public PromocaoDTO(Promocao promocao) {
		this.id = promocao.getId();
		this.nome = promocao.getNome();
		this.preco = promocao.getPreco();
		this.status = promocao.getStatus().getCod();
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

	public void setStatus(Integer status) {
		this.status = status;
	}

}
