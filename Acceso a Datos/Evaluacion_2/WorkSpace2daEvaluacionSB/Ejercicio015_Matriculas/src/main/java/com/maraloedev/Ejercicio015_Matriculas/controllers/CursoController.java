package com.maraloedev.Ejercicio015_Matriculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.services.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CursoController {

	@Autowired
	private CursoService cursoService;

	// Ver todos los cursos
	@GetMapping("/curso")
	public List<Curso> listarCurso() {
		return (List<Curso>)cursoService.findAll();
	}

	
	@PostMapping("/insertarCurso")
	public void insertarCurso(@RequestBody Curso curso) {
		cursoService.save(curso);
	}

	@PutMapping("/actualizarCurso")
	public void actualizarCurso(@RequestBody Curso curso) {
		cursoService.save(curso);
	}

	@GetMapping("/buscarCurso/{id}")
	public void buscarCurso(@PathVariable Long id) {
		cursoService.findById(id);
	}

	@DeleteMapping("/eliminarCurso/{id}")
	public void eliminarCurso(@PathVariable Long id) {
		cursoService.deleteById(id);

	}
}
