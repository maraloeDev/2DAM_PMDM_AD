package com.maraloedev.Ejercicio016_Banca.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuentas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "saldo")
	private String saldo;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Clientes cliente;
}
