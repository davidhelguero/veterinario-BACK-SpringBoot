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
@Table(name = "veterinario")
public class Veterinario extends Persona{
    private String matricula;

    public Veterinario(Integer id, String nombre, String apellido, String documento, boolean estado, String matricula) {
        super(id, nombre, apellido, documento, estado);
        this.matricula = matricula;
    }
}
