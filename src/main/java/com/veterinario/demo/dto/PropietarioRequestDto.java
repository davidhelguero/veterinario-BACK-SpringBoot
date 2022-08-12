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
public class PropietarioRequestDto {
    @NotEmpty(message = "Por favor ingrese un nombre")
    private String nombre;
    @NotEmpty(message = "Por favor ingrese un apellido")
    private String apellido;
    @NotEmpty(message = "Por favor ingrese un documento")
    @Pattern(regexp = "^[0-9]{7,8}$", message = "Ingrese el dni sin puntos. Recuerde que tiene 7 u 8 dígitos")
    private String documento;
    @NotEmpty(message = "Por favor ingrese un correo")
    /**  El pattern del correo se esta validando en el front  */
    //@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Formato de correo inválido")
    private String correo;
    @NotEmpty(message = "Por favor ingrese un teléfono")
    @Pattern(regexp = "^[0-9]{10}$", message = "Debe contener 10 dígitos")
    private String telefono;
}
