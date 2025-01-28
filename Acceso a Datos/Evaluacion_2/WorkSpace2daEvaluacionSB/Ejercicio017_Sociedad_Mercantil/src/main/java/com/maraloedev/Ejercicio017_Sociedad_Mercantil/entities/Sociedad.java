package com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sociedad")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sociedad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cif") private String cif;
	
	@Column(name = "nombre") private String nombre;
	
	@Column(name = "tipo") private String tipo;
	
	@Column(name = "capital") private double capital;

}
