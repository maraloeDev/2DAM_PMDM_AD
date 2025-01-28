package com.maraloedev.Ejercicio016_Banca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio016_Banca.entites.Prestamos;
import com.maraloedev.Ejercicio016_Banca.services.GenericService;

@RestController
public class PrestamosController {

	@Autowired
	private GenericService<Prestamos> genericService;


	// Buscar
	@GetMapping("/prestamo/{id}")
	public Prestamos findById(@PathVariable Long id) {
		return genericService.findById(id);
	}
}
