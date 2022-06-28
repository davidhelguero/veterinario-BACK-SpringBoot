package com.veterinario.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "historial_medico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id")
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "id_veterinario", referencedColumnName = "persona_id")
    private Veterinario veterinario;
    private boolean estado;
}
