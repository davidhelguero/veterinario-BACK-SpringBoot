package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.veterinario.demo.constants.EstadoAnimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming
public class AnimalResponseDto {
    private Integer id;
    private String nombre;
    private float peso;
    private LocalDate fechaCreacion;
    private EstadoAnimal estado;
}
