package com.petshop.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.ServicoDTO;
import com.petshop.modelo.Servico;
import com.petshop.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repo;

	public List<Servico> findAll() {
		return repo.findAll();
	}

	public List<Servico> findByCodTipoAnimal(Integer codTipoAnimal) {

		return repo.findByCodTipoAnimal(codTipoAnimal);
	}

	public List<Servico> findDistinctByPrecoContaining(String preco) {
		return repo.findDistinctByPrecoContaining(preco);
	}

	public List<Servico> findDistinctByNomeContaining(String nome) {
		return repo.findDistinctByNomeContaining(nome);
	}

	public Servico insert(Servico servico) {
		return repo.save(servico);
	}

	public List<ServicoDTO> toDto(List<Servico> servicos) {
		return servicos.stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList());
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
