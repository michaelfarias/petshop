package com.petshop.modelo.enums;

public enum StatusServico {

	DISPONIVEL(1, "Disponível"), INDISPONIVEL(2, "Indisponível");

	private int cod;
	private String descricao;

	private StatusServico(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static StatusServico toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusServico x : StatusServico.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id do serviço inválido: " + cod);
	}

}
