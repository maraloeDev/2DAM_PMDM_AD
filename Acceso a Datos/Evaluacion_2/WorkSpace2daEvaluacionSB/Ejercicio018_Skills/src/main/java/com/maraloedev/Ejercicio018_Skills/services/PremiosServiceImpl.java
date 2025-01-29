package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.entities.Competicion;
import com.maraloedev.Ejercicio018_Skills.entities.Premios;
import com.maraloedev.Ejercicio018_Skills.repositories.CompeticionRepository;
import com.maraloedev.Ejercicio018_Skills.repositories.PremiosRepository;

@Service
public class PremiosServiceImpl implements GenerateService<Premios>{
	
	@Autowired
	private PremiosRepository repo;

	@Override
	public List<Premios> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Premios item) {
		repo.save(item);
		
	}

	@Override
	public Premios findById(Long id) {
		Optional<Premios> object = repo.findById(id);
		Premios c = null;
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
