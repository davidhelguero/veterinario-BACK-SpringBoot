package com.veterinario.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String documento;
    private boolean estado;

    public Persona(Integer id, String nombre, String apellido, String documento, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.estado = estado;
    }
}
