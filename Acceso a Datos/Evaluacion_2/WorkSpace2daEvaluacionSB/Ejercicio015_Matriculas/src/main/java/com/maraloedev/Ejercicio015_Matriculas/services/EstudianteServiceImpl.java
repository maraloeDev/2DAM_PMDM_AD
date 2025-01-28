package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Estudiante;
import com.maraloedev.Ejercicio015_Matriculas.repositories.CursoRepository;
import com.maraloedev.Ejercicio015_Matriculas.repositories.EstudianteRepository;
@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public List<Estudiante> findAll() {
		return estudianteRepository.findAll();
	}

	@Override
	public void save(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
		
	}

	@Override
	public Estudiante findById(Long id) {
		Optional<Estudiante> cOptional = estudianteRepository.findById(id);
		Estudiante e = null;
		if(cOptional.isPresent()) {
			e = cOptional.get();
		}
		return e;
	}

	@Override
	public void deleteById(Long id) {
		estudianteRepository.deleteById(id);
		
	}

}
