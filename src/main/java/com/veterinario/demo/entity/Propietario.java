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
@Table(name = "propietario")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Propietario extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String correo;
    private String telefono;

    public Propietario(Integer id, String nombre, String apellido, String documento, boolean estado, String correo, String telefono) {
        super(id, nombre, apellido, documento, estado);
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
    }
}
