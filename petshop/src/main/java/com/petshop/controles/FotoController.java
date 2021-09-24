package com.petshop.controles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/fotos")
public class FotoController {

	@GetMapping("{nome}")
	public ResponseEntity<?> buscarImagem(@PathVariable String nome) {
		var filename = String.format("/tmp/petshop-disco/arquivos/%s", nome);

		try {
			var file = new File(filename);
			var path = Paths.get(file.getAbsolutePath());
			var resource = new ByteArrayResource(Files.readAllBytes(path));
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentLength(file.length()).body(resource);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

}
