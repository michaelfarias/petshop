package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.modelo.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
