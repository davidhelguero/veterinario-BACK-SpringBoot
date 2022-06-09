package com.veterinario.demo.repository;

import com.veterinario.demo.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.nombre=:nombre")
    List<Animal> findAnimalByNombre (String nombre);
}
