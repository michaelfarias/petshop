package com.petshop.form;

import javax.validation.constraints.NotEmpty;

public class ClienteForm {

	@NotEmpty(message = "O nome não pode ser vazio")
	private String nome;

	@NotEmpty(message = "O email não pode ser vazio")
	private String email;

	@NotEmpty(message = "O cpf não pode ser vazio")
	private String cpf;

	@NotEmpty(message = "O telefone não pode ser vazio")
	private String telefone;

	@NotEmpty(message = "O login não pode ser vazio")
	private String login;

	@NotEmpty(message = "O senha não pode ser vazio")
	private String senha;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}