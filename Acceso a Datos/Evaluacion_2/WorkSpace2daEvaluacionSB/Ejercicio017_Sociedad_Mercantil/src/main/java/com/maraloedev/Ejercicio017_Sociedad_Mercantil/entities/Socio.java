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
@Table(name = "socio")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "nombre") private String nombre;
	
	@Column(name = "apellidos") private String apellidos;
	
	@Column(name = "contacto") private int contacto;

}
