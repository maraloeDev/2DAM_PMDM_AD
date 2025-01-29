package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio018_Skills.entities.Modalidad;
import com.maraloedev.Ejercicio018_Skills.repositories.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements GenerateService<Modalidad>{
	
	@Autowired
	private ModalidadRepository repo;

	@Override
	public List<Modalidad> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Modalidad item) {
		repo.save(item);
		
	}

	@Override
	public Modalidad findById(Long id) {
		Optional<Modalidad> object = repo.findById(id);
		Modalidad c = null;
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
