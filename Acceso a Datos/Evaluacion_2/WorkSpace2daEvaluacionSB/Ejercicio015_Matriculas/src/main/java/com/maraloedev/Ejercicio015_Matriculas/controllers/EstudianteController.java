package com.maraloedev.Ejercicio015_Matriculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio015_Matriculas.entities.Estudiante;
import com.maraloedev.Ejercicio015_Matriculas.services.EstudianteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	// Ver todos los estudiates
	@GetMapping("/estudiantes")
	public List<Estudiante> listarEstudiante() {
		return estudianteService.findAll();
	}

	
	@PostMapping("/insertarEstudiante")
	public void insertarEstudiante(@RequestBody Estudiante estudiante) {
		estudianteService.save(estudiante);
	}

	@PutMapping("/actualizarEstudiante")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante) {
		estudianteService.save(estudiante);
	}

	@GetMapping("/buscarEstudiante/{id}")
	public void buscarEstudiante(@PathVariable Long id) {
		estudianteService.findById(id);
	}

	@DeleteMapping("/eliminarEstudiante/{id}")
	public void eliminarEstudiante(@PathVariable Long id) {
		estudianteService.deleteById(id);

	}
}
