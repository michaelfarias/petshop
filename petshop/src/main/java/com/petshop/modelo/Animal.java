package com.petshop.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.petshop.modelo.enums.TipoAnimal;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private Integer codTipo;
	private String raca;
	private double tamanho;
	private double peso;
	private Integer idade;

	@ManyToOne
	private Cliente cliente;

	public Animal() {
	}

	public Animal(String nome, Integer codTipo, String raca, double tamanho, double peso, Integer idade) {
		this.nome = nome;
		this.codTipo = codTipo;
		this.raca = raca;
		this.tamanho = tamanho;
		this.peso = peso;
		this.idade = idade;
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

	public TipoAnimal getTipo() {
		return TipoAnimal.toEnum(this.codTipo);
	}

	public void setTipo(TipoAnimal tipo) {
		this.codTipo = tipo.getCod();
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
