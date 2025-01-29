package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.entities.Competicion;
import com.maraloedev.Ejercicio018_Skills.repositories.CompeticionRepository;

@Service
public class CompeticionServiceImpl implements GenerateService<Competicion>{
	
	@Autowired
	private CompeticionRepository repo;

	@Override
	public List<Competicion> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Competicion item) {
		repo.save(item);
		
	}

	@Override
	public Competicion findById(Long id) {
		Optional<Competicion> object = repo.findById(id);
		Competicion c = null;
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
