package com.petshop.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.modelo.Cliente;
import com.petshop.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Cliente findByNome(String nome) {
		return repo.findByNome(nome);
	}

	public Cliente insert(Cliente cliente) {
		Cliente obj = repo.save(cliente);
		return obj;
	}
}
