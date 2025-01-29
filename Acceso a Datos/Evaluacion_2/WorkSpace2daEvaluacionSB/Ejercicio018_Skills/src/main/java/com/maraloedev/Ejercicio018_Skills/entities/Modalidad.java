package com.maraloedev.Ejercicio018_Skills.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modalidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "dni")
    private String dni;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "codigo")
    private int codigo;
    
    @OneToMany(mappedBy = "modalidad")
    private List<Premios> premios;
}
