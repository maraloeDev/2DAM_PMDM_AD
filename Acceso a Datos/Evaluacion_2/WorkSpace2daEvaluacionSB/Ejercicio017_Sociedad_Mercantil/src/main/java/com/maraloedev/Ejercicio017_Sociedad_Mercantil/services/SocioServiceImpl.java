package com.maraloedev.Ejercicio017_Sociedad_Mercantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Sociedad;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Socio;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.SociedadRepository;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.SocioRepository;

@Service
public class SocioServiceImpl implements GenericService<Socio>{
	
	@Autowired
	private SocioRepository repo;

	@Override
	public List<Socio> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Socio item) {
		repo.save(item);
		
	}

	@Override
	public Socio findById(Long id) {
		Optional<Socio> optional = repo.findById(id);
		Socio s = null;
		
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
