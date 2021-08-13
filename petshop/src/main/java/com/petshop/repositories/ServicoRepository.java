package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.modelo.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	List<Servico> findByCodTipoAnimal(Integer codTipoAnimal);
}
