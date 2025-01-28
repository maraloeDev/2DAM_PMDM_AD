package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Matricula;

public interface MatriculaService {
	
	//Listar todos las matriculas
	List<Matricula> findAll();
	
	//Insertar matriculas
	void save(Matricula matricula);
	
	//Buscar matricula
	Matricula findById(Long id);
	
	//Eliminar matricula
	void deleteById(Long id);

}
