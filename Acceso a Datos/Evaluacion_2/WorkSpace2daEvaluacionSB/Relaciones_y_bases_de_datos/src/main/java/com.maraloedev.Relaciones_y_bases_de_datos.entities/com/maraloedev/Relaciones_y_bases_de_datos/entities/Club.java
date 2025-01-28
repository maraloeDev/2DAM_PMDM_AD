package com.maraloedev.Relaciones_y_bases_de_datos.entities;

import java.util.List;

import com.maraloedev.Relaciones_y_bases_de_datos.Competicion;
import com.maraloedev.Relaciones_y_bases_de_datos.Entrenador;
import com.maraloedev.Relaciones_y_bases_de_datos.Jugador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clubes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Club {
	
	@Id
	
	// Identity incrementa el valor de la clave primaria en 1
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	
	//RELACIONES ENTRE ENTIDADES
	
	// OneToOne crea una relación uno a uno entre dos entidades
	// OneToMany crea una relación uno a muchos entre dos entidades
	// ManyToMany crea una relación muchos a muchos entre dos entidades
	@OneToOne
	private Entrenador entrenador;
	
	
	@OneToMany
	
	// JoinColumn se utiliza para especificar
	// una columna en la tabla de la entidad propietaria
	// que se utiliza para unir la tabla de la entidad relacionada
	@JoinColumn(name = "id_club")
	private List<Jugador> jugadores;
	
	// En la lista de competiciones se guardan las competiciones en las que participa el club
	
	@ManyToMany
	
	private List<Competicion> competiciones; 
}
