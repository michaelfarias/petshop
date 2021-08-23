package com.petshop.dto;

import com.petshop.modelo.Servico;
import com.petshop.modelo.enums.StatusServico;

public class ServicoDTO {

	private Integer id;

	private String nome;
	private Double preco;
	private Integer status;
	private PromocaoDTO promocao;

	public ServicoDTO() {
	}

	public ServicoDTO(Servico obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
		this.status = obj.getStatus().getCod();
		this.promocao = new PromocaoDTO(obj.getPromocao());
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public StatusServico getStatus() {
		return StatusServico.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public PromocaoDTO getPromocao() {
		return promocao;
	}

	public void setPromocao(PromocaoDTO promocao) {
		this.promocao = promocao;
	}

}
