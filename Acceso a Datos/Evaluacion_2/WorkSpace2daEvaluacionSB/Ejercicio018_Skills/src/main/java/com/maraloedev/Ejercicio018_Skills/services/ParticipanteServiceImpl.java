package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio018_Skills.entities.Participante;
import com.maraloedev.Ejercicio018_Skills.repositories.ParticipanteRepository;

@Service
public class ParticipanteServiceImpl implements GenerateService<Participante>{
	
	@Autowired
	private ParticipanteRepository repo;

	@Override
	public List<Participante> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Participante item) {
		repo.save(item);
		
	}

	@Override
	public Participante findById(Long id) {
		Optional<Participante> object = repo.findById(id);
		Participante c = null;
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
