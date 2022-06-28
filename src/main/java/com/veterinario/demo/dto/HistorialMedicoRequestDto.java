package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming
public class HistorialMedicoRequestDto {

    @NotEmpty(message = "Ingrese una descripción")
    private String descripcion;
    @NotNull(message = "Ingrese el animal atendido")
    private Integer id_animal;
    @NotNull(message = "Ingrese el veterinario que lo atendió")
    private Integer id_veterinario;

}