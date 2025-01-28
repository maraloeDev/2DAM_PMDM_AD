package com.maraloedev.Ejercicio015_Matriculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio015_Matriculas.entities.Matricula;
import com.maraloedev.Ejercicio015_Matriculas.services.MatriculaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;

	// Ver todos los estudiates
	@GetMapping("/matricula")
	public List<Matricula> listarMatricula() {
		return matriculaService.findAll();
	}

	
	@PostMapping("/insertarMatricula")
	public void insertarMatricula(@RequestBody Matricula matricula) {
		matriculaService.save(matricula);
	}

	@PutMapping("/actualizarMatricula/{id}")
	public void actualizarMatricula(@RequestBody Matricula matricula, @PathVariable Long id) {
		matriculaService.save(matricula);
	}

	@GetMapping("/buscarMatricula/{id}")
	public void buscarMatricula(@PathVariable Long id) {
		matriculaService.findById(id);
	}

	@DeleteMapping("/eliminarMatricula/{id}")
	public void eliminarMatricula(@PathVariable Long id) {
		matriculaService.deleteById(id);

	}
}
