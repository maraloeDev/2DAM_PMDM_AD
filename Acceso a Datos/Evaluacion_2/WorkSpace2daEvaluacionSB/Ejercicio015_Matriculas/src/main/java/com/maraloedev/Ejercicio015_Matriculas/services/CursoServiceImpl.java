package com.maraloedev.Ejercicio015_Matriculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public void save(Curso curso) {
		cursoRepository.save(curso);
		
	}

	@Override
	public Curso findById(Long id) {
		Optional<Curso> cOptional = cursoRepository.findById(id);
		Curso c = null;
		if(cOptional.isPresent()) {
			c = cOptional.get();
		}
		return c;
	}

	@Override
	public void deleteById(Long id) {
		cursoRepository.deleteById(id);
		
	}

}
