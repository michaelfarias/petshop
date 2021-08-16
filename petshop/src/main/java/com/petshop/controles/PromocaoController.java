package com.petshop.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.dto.PromocaoDTO;
import com.petshop.modelo.Promocao;
import com.petshop.servicos.PromocaoService;

@RestController
@RequestMapping(value = "promocoes")
public class PromocaoController {

	@Autowired
	private PromocaoService service;

	@GetMapping
	public ResponseEntity<?> listarPromocoes() {
		List<Promocao> promocoes = service.findAll();
		List<PromocaoDTO> promocoesDto = service.toDto(promocoes);

		return ResponseEntity.ok(promocoesDto);
	}
}
