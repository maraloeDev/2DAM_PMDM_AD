package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.entities.Competicion;
import com.maraloedev.Ejercicio018_Skills.entities.Tutor;
import com.maraloedev.Ejercicio018_Skills.repositories.CompeticionRepository;
import com.maraloedev.Ejercicio018_Skills.repositories.TutorRepository;

@Service
public class TutorServiceImpl implements GenerateService<Tutor>{
	
	@Autowired
	private TutorRepository repo;

	@Override
	public List<Tutor> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Tutor item) {
		repo.save(item);
		
	}

	@Override
	public Tutor findById(Long id) {
		Optional<Tutor> object = repo.findById(id);
		Tutor c = null;
		if(object.isPresent()) {
			c = object.get();
		}
		return c;	
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
		
	}

}
