package com.petshop.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.ClienteDTO;
import com.petshop.modelo.Cliente;
import com.petshop.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Cliente findByNome(String nome) throws ObjectNotFoundException {
		Cliente cliente = repo.findByNome(nome);

		if (cliente != null)
			return cliente;

		throw new ObjectNotFoundException("Cliente não encontrado! Tipo " + Cliente.class.getName());

	}

	public Cliente insert(Cliente cliente) {
		Cliente obj = repo.save(cliente);
		return obj;
	}

	public void update(ClienteDTO clienteDto) {
		Cliente cliente = repo.findById(clienteDto.getId()).get();

		cliente.setNome(clienteDto.getNome());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setTelefone(clienteDto.getTelefone());

		repo.save(cliente);
	}
}
