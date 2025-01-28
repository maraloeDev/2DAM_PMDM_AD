package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Estudiante;
import com.maraloedev.Ejercicio015_Matriculas.entities.Matricula;
import com.maraloedev.Ejercicio015_Matriculas.entities.Universidad;
import com.maraloedev.Ejercicio015_Matriculas.repositories.CursoRepository;
import com.maraloedev.Ejercicio015_Matriculas.repositories.EstudianteRepository;
import com.maraloedev.Ejercicio015_Matriculas.repositories.MatriculaRepository;
import com.maraloedev.Ejercicio015_Matriculas.repositories.UniversidadRepository;
@Service
public class UniversidadServiceImpl implements UniversidadService{
	
	@Autowired
	private UniversidadRepository universidadRepository;

	@Override
	public List<Universidad> findAll() {
		return universidadRepository.findAll();
	}

	@Override
	public void save(Universidad universidad) {
		universidadRepository.save(universidad);
		
	}

	@Override
	public Universidad findById(Long id) {
		Optional<Universidad> cOptional = universidadRepository.findById(id);
		Universidad u = null;
		if(cOptional.isPresent()) {
			u = cOptional.get();
		}
		return u;
	}

	@Override
	public void deleteById(Long id) {
		universidadRepository.deleteById(id);
		
	}

}
