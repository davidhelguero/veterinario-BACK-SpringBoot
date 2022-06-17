package com.veterinario.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "propietario")
public class Propietario extends Persona{
    private String correo;
    private String telefono;

    public Propietario(Integer id, String nombre, String apellido, String documento, boolean estado, String correo, String telefono) {
        super(id, nombre, apellido, documento, estado);
        this.correo = correo;
        this.telefono = telefono;
    }
}
