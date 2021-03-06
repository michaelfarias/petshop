package com.petshop.controles;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshop.dto.ServicoDTO;
import com.petshop.form.ServicoForm;
import com.petshop.modelo.Servico;
import com.petshop.servicos.ServicoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/servicos")
public class ServicoController {

	@Autowired
	private ServicoService service;

	@GetMapping
	public ResponseEntity<?> listarServicos() {
		List<Servico> servicos = service.findAll();
		List<ServicoDTO> servicosDto = service.toDto(servicos);
		return ResponseEntity.ok().body(servicosDto);
	}

	@GetMapping(value = "animal")
	public ResponseEntity<?> listarServicoPorAnimal(@RequestParam(value = "animal") Integer codTipoAnimal) {
		List<Servico> servicos = service.findByCodTipoAnimal(codTipoAnimal);
		List<ServicoDTO> servicosDto = service.toDto(servicos);

		return ResponseEntity.ok(servicosDto);
	}

	@GetMapping(value = "preco")
	public ResponseEntity<?> listarServicoPorPreco(@RequestParam(value = "preco") String preco) {
		List<Servico> servicos = service.findDistinctByPrecoContaining(preco);
		List<ServicoDTO> servicosDto = service.toDto(servicos);

		return ResponseEntity.ok(servicosDto);
	}

	@GetMapping(value = "nome")
	public ResponseEntity<?> listaServicoPorNome(@RequestParam(value = "nome") String nome) {
		List<Servico> servicos = service.findDistinctByNomeContaining(nome);
		List<ServicoDTO> servicoDto = service.toDto(servicos);

		return ResponseEntity.ok().body(servicoDto);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarServico(@RequestBody ServicoForm servicoForm) {
		Servico servico = new Servico(servicoForm.getNome(), servicoForm.getDescricao(), null, servicoForm.getPreco(),
				servicoForm.getAnimal().getCod(), servicoForm.getStatus().getCod());

		servico.setPromocao(servicoForm.getPromocao());

		Servico obj = service.insert(servico);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizarServico(@RequestBody ServicoDTO servicoDto) {
		service.update(servicoDto);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletarServico(@PathVariable(value = "id") Integer id) {
		try {
			service.delete(id);
			return ResponseEntity.accepted().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}
}
