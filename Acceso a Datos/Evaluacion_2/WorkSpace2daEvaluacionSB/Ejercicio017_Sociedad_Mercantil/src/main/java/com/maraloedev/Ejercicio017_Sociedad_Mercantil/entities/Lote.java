package com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private int total;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "porcentaje")
    private double porcentaje;

    // Relación One-to-One con Socio
    @OneToOne(mappedBy = "lote", cascade = CascadeType.ALL)
    private Socio socio;

    // Relación One-to-Many con Participacion
    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    private List<Participacion> participaciones = new ArrayList<>();
}
