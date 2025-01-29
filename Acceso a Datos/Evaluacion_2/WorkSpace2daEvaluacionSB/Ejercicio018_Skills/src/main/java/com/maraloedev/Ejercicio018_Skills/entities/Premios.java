package com.maraloedev.Ejercicio018_Skills.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "premio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Premios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "cuantia")
    private int cuantia;
    
    @ManyToOne
    @JoinColumn(name = "modalidad_id")
    private Modalidad modalidad;
}