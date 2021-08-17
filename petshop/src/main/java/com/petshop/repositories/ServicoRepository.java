package com.petshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petshop.modelo.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	List<Servico> findByCodTipoAnimal(Integer codTipoAnimal);

	List<Servico> findDistinctByNomeContaining(String nome);

	@Query(nativeQuery = true, value = "SELECT * FROM servico s WHERE s.preco LIKE CONCAT('%', :preco, '%')")
	List<Servico> findDistinctByPrecoContaining(@Param("preco") String preco);
}
