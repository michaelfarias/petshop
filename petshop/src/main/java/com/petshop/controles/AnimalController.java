package com.petshop.controles;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshop.dto.AnimalDTO;
import com.petshop.modelo.Animal;
import com.petshop.servicos.AnimalService;

@RestController
@RequestMapping(value = "/animais")
public class AnimalController {

	@Autowired
	private AnimalService service;

	@PostMapping
	public ResponseEntity<?> cadastrarAnimal(@RequestBody AnimalDTO objDto) {
		Animal obj = service.fromDTO(objDto);
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
