package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.veterinario.demo.entity.Animal;
import com.veterinario.demo.entity.Veterinario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming
public class HistorialMedicoResponseDto {
    private Integer id;
    private LocalDate fecha;
    private String descripcion;
    private Animal animal;
    private Veterinario veterinario;
    private boolean estado;
}
