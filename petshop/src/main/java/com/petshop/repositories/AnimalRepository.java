package com.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.modelo.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
