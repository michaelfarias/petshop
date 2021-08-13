package com.petshop.modelo.enums;

public enum FormaPagamento {
	AVISTA(1, "À Vista"), CHEQUE(2, "Cheque"), CARTAODECREDITO(3, "Cartão de credito");

	private int cod;
	private String descricao;

	private FormaPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static FormaPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (FormaPagamento x : FormaPagamento.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}

		throw new IllegalArgumentException("ID Enum inválido: " + cod);
	}
}
