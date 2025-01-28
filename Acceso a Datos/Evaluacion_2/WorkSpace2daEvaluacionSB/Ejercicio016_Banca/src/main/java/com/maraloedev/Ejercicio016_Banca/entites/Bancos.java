package com.maraloedev.Ejercicio016_Banca.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "banco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bancos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "cif")
	private String cif;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "domicilio_fiscal")
	private String domicilioFiscal;

	@ManyToMany(mappedBy = "bancos")
	private Set<Clientes> clientes;
}
