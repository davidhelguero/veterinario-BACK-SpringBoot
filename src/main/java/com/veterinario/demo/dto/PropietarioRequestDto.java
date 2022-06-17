package com.veterinario.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming
public class PropietarioRequestDto {
    @NotEmpty(message = "Por favor ingrese un nombre")
    private String nombre;
    @NotEmpty(message = "Por favor ingrese un apellido")
    private String apellido;
    @NotEmpty(message = "Por favor ingrese un documento")
    private String documento;
    @NotEmpty(message = "Por favor ingrese un correo")
    private String correo;
    @NotEmpty(message = "Por favor ingrese un teléfono")
    private String telefono;
}
