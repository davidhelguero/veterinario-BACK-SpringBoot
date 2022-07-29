package com.veterinario.demo.repository;

import com.veterinario.demo.dto.TipoAnimalResponseDto;
import com.veterinario.demo.entity.TipoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoAnimalRepository extends JpaRepository<TipoAnimal,Integer> {

    @Query("SELECT a FROM TipoAnimal a WHERE a.estado=:estado")
    List<TipoAnimal> findTipoAnimalByEstado(boolean estado);

    @Query("SELECT count(a)>0 from TipoAnimal a where a.descripcion=:descripcion")
    boolean existsByDescripcion(String descripcion);

}
