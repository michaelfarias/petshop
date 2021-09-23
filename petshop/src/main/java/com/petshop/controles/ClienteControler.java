package com.petshop.controles;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petshop.dto.ClienteDTO;
import com.petshop.modelo.Cliente;
import com.petshop.modelo.Foto;
import com.petshop.servicos.ClienteService;
import com.petshop.storage.Disco;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clientes")
public class ClienteControler {

	@Autowired
	private ClienteService service;
	@Autowired
	private Disco disco;

	@GetMapping
	public ResponseEntity<?> listarClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "cliente")
	public ResponseEntity<?> listaClientePorNome(@RequestParam("nome") String nome) throws ObjectNotFoundException {
		Cliente cliente = service.findByNome(nome);

		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@RequestParam String nome, @RequestParam String email,
			@RequestParam String cpf, @RequestParam String telefone, @RequestParam String login,
			@RequestParam String senha, @RequestParam MultipartFile foto) {

		Cliente cliente = new Cliente(login, senha, nome, email, cpf, telefone);

		Foto f1 = new Foto();
		f1.setCliente(cliente);
		f1.setFoto(foto.getOriginalFilename());

		cliente.setFoto(f1);

		Cliente obj = service.insert(cliente);
		disco.salvarArquivo(foto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.ok(uri);
	}

	@PutMapping
	public ResponseEntity<?> atualizarCliente(@RequestBody ClienteDTO clienteDto) {
		try {
			service.update(clienteDto);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
