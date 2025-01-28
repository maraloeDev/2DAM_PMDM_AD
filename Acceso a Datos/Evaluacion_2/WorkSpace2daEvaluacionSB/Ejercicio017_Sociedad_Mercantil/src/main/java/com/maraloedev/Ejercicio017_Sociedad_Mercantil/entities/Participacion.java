package com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "participacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private int valor;

    @Column(name = "fecha")
    private Date fecha;

    // Relación Many-to-One con Lote
    @ManyToOne
    @JoinColumn(name = "lote_id") // Clave foránea hacia Lote
    private Lote lote;
}
