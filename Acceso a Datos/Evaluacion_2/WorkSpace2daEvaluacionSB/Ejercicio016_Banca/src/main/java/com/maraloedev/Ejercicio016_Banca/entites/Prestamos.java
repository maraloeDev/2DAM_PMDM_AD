package com.maraloedev.Ejercicio016_Banca.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Table(name = "prestamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "interes")
	private double interes;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Clientes cliente;
}
