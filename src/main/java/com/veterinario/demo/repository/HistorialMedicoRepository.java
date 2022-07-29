package com.veterinario.demo.repository;

import com.veterinario.demo.entity.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer> {

    @Query("SELECT a FROM HistorialMedico a WHERE a.estado=:estado")
    List<HistorialMedico> findHistorialMedicoByEstado(boolean estado);
}
