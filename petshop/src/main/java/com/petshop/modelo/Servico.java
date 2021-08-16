package com.petshop.modelo;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petshop.modelo.enums.StatusServico;
import com.petshop.modelo.enums.TipoAnimal;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String descricao;
	@ElementCollection
	private List<LocalTime> horaAtendimentos;
	private double preco;
	private Integer codTipoAnimal;
	private Integer status;

	@JsonIgnore
	@ManyToMany
	private List<Compra> compras;

	@JsonIgnore
	@ManyToOne
	private Promocao promocao;

	public Servico() {

	}

	public Servico(String nome, String descricao, List<LocalTime> horaAtendimentos, double preco, Integer codTipoAnimal,
			Integer status) {

		this.nome = nome;
		this.descricao = descricao;
		this.horaAtendimentos = horaAtendimentos;
		this.preco = preco;
		this.codTipoAnimal = codTipoAnimal;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<LocalTime> getHoraAtendimentos() {
		return horaAtendimentos;
	}

	public void setHoraAtendimentos(List<LocalTime> horaAtendimentos) {
		this.horaAtendimentos = horaAtendimentos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public TipoAnimal getTipoAnimal() {
		return TipoAnimal.toEnum(this.codTipoAnimal);
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.codTipoAnimal = tipoAnimal.getCod();
	}

	public StatusServico getStatus() {
		return StatusServico.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

}
