package com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sociedad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sociedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cif")
    private String cif;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "capital")
    private double capital;

    // Relación One-to-Many con Socios
    @OneToMany(mappedBy = "sociedad", cascade = CascadeType.ALL)
    private List<Socio> socios = new ArrayList<>();
}
