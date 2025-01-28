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
@Table(name = "lote")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "total") private int total;
	
	@Column(name = "nombre") private String nombre;
	
	@Column(name = "porcentaje") private double porcentaje;

}
