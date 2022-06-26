package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming
public class TipoAnimalResponseDto {
    private int id;
    private String descripcion;
    private boolean estado;
}
