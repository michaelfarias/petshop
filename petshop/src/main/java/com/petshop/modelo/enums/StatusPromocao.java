package com.petshop.modelo.enums;

public enum StatusPromocao {

	DISPONIVEL(1, "Disponível"), INDISPONIVEL(2, "Indisponível");

	private int cod;
	private String descricao;

	private StatusPromocao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static StatusPromocao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (StatusPromocao x : StatusPromocao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("ID do status inválida: " + cod);
	}
}
