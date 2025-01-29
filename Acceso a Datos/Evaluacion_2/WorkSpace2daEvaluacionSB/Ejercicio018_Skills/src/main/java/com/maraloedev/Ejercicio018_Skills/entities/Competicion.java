package com.maraloedev.Ejercicio018_Skills.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "competicion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "año")
    private int anio;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @ManyToMany(mappedBy = "competiciones")
    private List<Centro> centros;
    
    @OneToMany(mappedBy = "competicionAnterior")
    private List<Competicion> competicionesSuperiores;
    
    @ManyToOne
    @JoinColumn(name = "competicion_anterior_id")
    private Competicion competicionAnterior;
}
