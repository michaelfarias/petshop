package com.petshop.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dto.AnimalDTO;
import com.petshop.modelo.Animal;
import com.petshop.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repo;

	public Animal insert(Animal animal) {
		return repo.save(animal);
	}

	public Animal fromDTO(AnimalDTO objDto) {
		Animal newObj = new Animal(objDto.getNome(), objDto.getCodTipo(), objDto.getRaca(), objDto.getTamanho(),
				objDto.getPeso(), objDto.getIdade());
		newObj.setCliente(objDto.getCliente());

		return newObj;
	}
}
