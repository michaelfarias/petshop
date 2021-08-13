package com.petshop.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.servicos.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControler {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<?> listarClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}
}
