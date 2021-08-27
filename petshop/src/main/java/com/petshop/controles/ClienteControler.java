package com.petshop.controles;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshop.modelo.Cliente;
import com.petshop.servicos.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clientes")
public class ClienteControler {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<?> listarClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "cliente")
	public ResponseEntity<?> listaClientePorNome(@RequestParam("nome") String nome) {
		Cliente cliente = service.findByNome(nome);

		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente obj = service.insert(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.ok(uri);
	}
}
