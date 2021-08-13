package com.petshop.modelo.enums;

public enum TipoAnimal {

	MAMIFERO(1, "Mamífero"), PEIXE(2, "Peixe"), REPTIL(3, "Réptil"), AVE(4, "Ave"), ANFIBIO(5, "Anfíbio");

	private int cod;
	private String descricao;

	private TipoAnimal(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String descricao() {
		return this.descricao;
	}

	public static TipoAnimal toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoAnimal x : TipoAnimal.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("ID do animal inválido: " + cod);
	}
}
