package com.veterinario.demo.entity;

import com.veterinario.demo.constants.EstadoAnimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private float peso;
    @Enumerated(EnumType.STRING)
    private EstadoAnimal estado;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
}
