package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;

public interface CursoService {
	
	//Listar todos los cursos
	List<Curso> findAll();
	
	//Insertar curso
	void save(Curso curso);
	
	//Buscar Curso
	Curso findById(Long id);
	
	//Eliminar Curso
	void deleteById(Long id);
}
