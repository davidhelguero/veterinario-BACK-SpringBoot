package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming
public class VeterinarioRequestDto {
    @NotEmpty(message = "Por favor ingrese un nombre")
    private String nombre;
    @NotEmpty(message = "Por favor ingrese un apellido")
    private String apellido;
    @NotEmpty(message = "Por favor ingrese un documento")
    @Pattern(regexp = "^[0-9]{7,8}$", message = "Ingrese el dni sin puntos. Recuerde que tiene 7 u 8 dígitos")
    private String documento;
    @NotEmpty(message = "Por favor ingrese una matricula")
    @Pattern(regexp = "^[0-9]{5}$", message = "La matricula contiene 5 dígitos")
    private String matricula;
}
