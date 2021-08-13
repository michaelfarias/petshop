package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.modelo.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

}
