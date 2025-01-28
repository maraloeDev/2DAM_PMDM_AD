package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Estudiante;

public interface EstudianteService {
	
	//Listar todos los estudiantes
	List<Estudiante> findAll();
	
	//Insertar estudiantes
	void save(Estudiante estudiante);
	
	//Buscar estudiante
	Estudiante findById(Long id);
	
	//Eliminar estudiantes
	void deleteById(Long id);

}
