package com.petshop.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.modelo.Servico;
import com.petshop.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repo;

	public List<Servico> findByCodTipoAnimal(Integer codTipoAnimal) {

		return repo.findByCodTipoAnimal(codTipoAnimal);
	}

	public List<Servico> findDistinctByNomeContaining(String nome) {
		return repo.findDistinctByNomeContaining(nome);
	}

	public Servico insert(Servico servico) {
		return repo.save(servico);
	}

}
