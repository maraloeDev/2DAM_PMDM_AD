package com.maraloedev.Ejercicio016_Banca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio016_Banca.entites.Clientes;
import com.maraloedev.Ejercicio016_Banca.services.GenericService;

@RestController
public class ClientesController {

	@Autowired
	private GenericService<Clientes> genericService;

	// Crear
	@PostMapping("/cliente")
	public void insertBank(@RequestBody Clientes clientes) {
			genericService.save(clientes);
	}
	
	// Buscar
		@GetMapping("/cliente/{id}")
		public Clientes findById(@PathVariable Long id) {
			return genericService.findById(id);
		}

	// Actualizar
		@PutMapping("/cliente/{id}")
	public void updateBank(@RequestBody Clientes clientes, @PathVariable Long id) {
			genericService.save(clientes);
	}
}
