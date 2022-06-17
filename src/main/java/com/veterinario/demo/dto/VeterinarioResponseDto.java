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
public class VeterinarioResponseDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String documento;
    private boolean estado;
    private String matricula;
}
