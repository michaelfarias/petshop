package com.petshop.form;

import com.petshop.modelo.Promocao;
import com.petshop.modelo.enums.StatusServico;
import com.petshop.modelo.enums.TipoAnimal;

public class ServicoForm {

	private String nome;
	private String descricao;
	private Double preco;
	private Integer animal;
	private Integer status;

	private Promocao promocao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoAnimal getAnimal() {
		return TipoAnimal.toEnum(this.animal);
	}

	public void setAnimal(Integer animal) {
		this.animal = animal;
	}

	public StatusServico getStatus() {
		return StatusServico.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

}
