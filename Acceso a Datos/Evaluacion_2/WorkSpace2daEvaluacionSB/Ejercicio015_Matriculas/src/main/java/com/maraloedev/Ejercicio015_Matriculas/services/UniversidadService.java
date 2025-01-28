package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Matricula;
import com.maraloedev.Ejercicio015_Matriculas.entities.Universidad;

public interface UniversidadService {
	
	//Listar todos las universidades
	List<Universidad> findAll();
	
	//Insertar universidades
	void save(Universidad universidad);
	
	//Buscar universidades
	Universidad findById(Long id);
	
	//Eliminar universidades
	void deleteById(Long id);

}
