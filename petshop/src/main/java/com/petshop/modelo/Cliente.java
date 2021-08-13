package com.petshop.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario {

	private String nome;
	private String email;
	private String cpf;
	private String telefone;

	@OneToMany
	private List<Animal> animais;

	@OneToMany
	private List<Compra> compras;

	public Cliente() {
		super();
	}

	public Cliente(String login, String senha, String nome, String email, String cpf, String telefone) {
		super.setLogin(login);
		super.setSenha(senha);

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}
