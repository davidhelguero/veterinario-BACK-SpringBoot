package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming
public class AnimalRequestDto {
    @NotEmpty(message = "Por favor ingrese un nombre")
    private String nombre;
    @NotNull(message = "Por favor ingrese el peso")
    private float peso;
    private String imagen;
}
