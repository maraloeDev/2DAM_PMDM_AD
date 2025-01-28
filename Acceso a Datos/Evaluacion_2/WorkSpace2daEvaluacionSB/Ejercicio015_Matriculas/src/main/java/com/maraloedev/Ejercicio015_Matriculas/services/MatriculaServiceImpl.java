package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Estudiante;
import com.maraloedev.Ejercicio015_Matriculas.entities.Matricula;
import com.maraloedev.Ejercicio015_Matriculas.repositories.CursoRepository;
import com.maraloedev.Ejercicio015_Matriculas.repositories.EstudianteRepository;
import com.maraloedev.Ejercicio015_Matriculas.repositories.MatriculaRepository;
@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@Override
	public void save(Matricula matricula) {
		matriculaRepository.save(matricula);
		
	}

	@Override
	public Matricula findById(Long id) {
		Optional<Matricula> cOptional = matriculaRepository.findById(id);
		Matricula m = null;
		if(cOptional.isPresent()) {
			m = cOptional.get();
		}
		return m;
	}

	@Override
	public void deleteById(Long id) {
		matriculaRepository.deleteById(id);
		
	}

}
