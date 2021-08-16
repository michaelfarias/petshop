package com.petshop.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.PromocaoDTO;
import com.petshop.modelo.Promocao;
import com.petshop.repositories.PromocaoRepository;

@Service
public class PromocaoService {

	@Autowired
	private PromocaoRepository repo;

	public List<Promocao> findAll() {
		return repo.findAll();
	}

	public List<PromocaoDTO> toDto(List<Promocao> promocoes) {
		return promocoes.stream().map(x -> new PromocaoDTO(x)).collect(Collectors.toList());
	}
}
