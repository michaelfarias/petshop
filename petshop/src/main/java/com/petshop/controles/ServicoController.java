package com.petshop.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.servicos.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoService service;

	@GetMapping(value = "animal")
	public ResponseEntity<?> listarServicoPorAnimal(@RequestParam(value = "animal") Integer codTipoAnimal) {
		return ResponseEntity.ok(service.findByCodTipoAnimal(codTipoAnimal));
	}

	@GetMapping(value = "nome")
	public ResponseEntity<?> listaServicoPorNome(@RequestParam(value = "nome") String nome) {
		return ResponseEntity.ok().body(service.findDistinctByNomeContaining(nome));
	}
}
