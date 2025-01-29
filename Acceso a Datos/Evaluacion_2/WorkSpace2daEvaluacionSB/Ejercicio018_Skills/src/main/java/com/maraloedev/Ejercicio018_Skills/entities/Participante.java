package com.maraloedev.Ejercicio018_Skills.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "participante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "tipo")
    private int tipo;
    
    @Column(name = "puntuacion")
    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "centro_id")
    private Centro centro;
    
    @ManyToOne
    @JoinColumn(name = "competicion_id")
    private Competicion competicion;
    
    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
    
    @ManyToOne
    @JoinColumn(name = "modalidad_id")
    private Modalidad modalidad;
}
