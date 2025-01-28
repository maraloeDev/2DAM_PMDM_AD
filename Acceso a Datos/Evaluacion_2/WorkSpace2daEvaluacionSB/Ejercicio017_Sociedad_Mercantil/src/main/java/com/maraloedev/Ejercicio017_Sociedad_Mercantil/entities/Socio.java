package com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "socio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "contacto")
    private int contacto;

    // Relación Many-to-One con Sociedad
    @ManyToOne
    @JoinColumn(name = "sociedad_id") // Clave foránea hacia Sociedad
    private Sociedad sociedad;

    // Relación One-to-One con Lote
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lote_id") // Clave foránea hacia Lote
    private Lote lote;
}