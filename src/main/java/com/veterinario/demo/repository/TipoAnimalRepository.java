package com.veterinario.demo.repository;

import com.veterinario.demo.entity.TipoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAnimalRepository extends JpaRepository<TipoAnimal,Integer> {

}
