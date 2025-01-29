package com.maraloedev.Ejercicio018_Skills.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Centro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "contacto")
    private int contacto;
    
    @OneToMany(mappedBy = "centro")
    private List<Participante> participantes;
    
    @ManyToMany
    @JoinTable(
        name = "centro_competicion",
        joinColumns = @JoinColumn(name = "centro_id"),
        inverseJoinColumns = @JoinColumn(name = "competicion_id")
    )
    private List<Competicion> competiciones;
}
