package com.maraloedev.Ejercicio015_Matriculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio015_Matriculas.entities.Universidad;
import com.maraloedev.Ejercicio015_Matriculas.services.UniversidadService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UniversidadController {

	@Autowired
	private UniversidadService universidadService;

	// Ver todos los estudiates
	@GetMapping("/universidad")
	public List<Universidad> listarUniversidad() {
		return universidadService.findAll();
	}

	
	@PostMapping("/insertarUniversidad")
	public void insertarUniversidad(@RequestBody Universidad universidad) {
		universidadService.save(universidad);
	}

	@PutMapping("/actualizarUniversidad")
	public void actualizarUniversidad(@RequestBody Universidad universidad) {
		universidadService.save(universidad);
	}

	@GetMapping("/buscarUniversidad/{id}")
	public void buscarUniversidad(@PathVariable Long id) {
		universidadService.findById(id);
	}

	@DeleteMapping("/eliminarUniversidad/{id}")
	public void eliminarUniversidad(@PathVariable Long id) {
		universidadService.deleteById(id);

	}
}
