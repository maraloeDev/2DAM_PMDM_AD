package com.maraloedev.Ejercicio017_Sociedad_Mercantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Sociedad;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.SociedadRepository;

@Service
public class SociedadServiceImpl implements GenericService<Sociedad>{
	
	@Autowired
	private SociedadRepository repo;

	@Override
	public List<Sociedad> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Sociedad item) {
		repo.save(item);
		
	}

	@Override
	public Sociedad findById(Long id) {
		Optional<Sociedad> optional = repo.findById(id);
		Sociedad s = null;
		
		if(optional.isPresent()) {
			s = optional.get();
		}
		return s;
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
		
	}

}
