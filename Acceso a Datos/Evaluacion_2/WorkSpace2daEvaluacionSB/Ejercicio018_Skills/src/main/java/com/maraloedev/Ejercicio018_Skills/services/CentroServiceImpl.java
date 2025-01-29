package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.repositories.CentroRepository;

@Service
public class CentroServiceImpl implements GenerateService<Centro> {
	
	@Autowired
	private CentroRepository repo;

	@Override
	public List<Centro> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Centro item) {
		repo.save(item);
	}

	@Override
	public Centro findById(Long id) {
		Optional<Centro> object = repo.findById(id);
		Centro c = null;
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
