package com.maraloedev.Ejercicio016_Banca.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "contacto")
	private String contacto;

	@ManyToMany
	@JoinTable(
		name = "cliente_banco",
		joinColumns = @JoinColumn(name = "cliente_id"),
		inverseJoinColumns = @JoinColumn(name = "banco_id")
	)
	private Set<Bancos> bancos;

	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Cuentas cuenta;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Prestamos> prestamos;
}
