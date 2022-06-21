package com.veterinario.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "veterinario")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Veterinario extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricula;

    public Veterinario(Integer id, String nombre, String apellido, String documento, boolean estado, String matricula) {
        super(id, nombre, apellido, documento, estado);
        this.id = id;
        this.matricula = matricula;
    }
}
