package com.maraloedev.Ejercicio017_Sociedad_Mercantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Participacion;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Sociedad;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.ParticipacionRepository;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.SociedadRepository;

@Service
public class ParticipacionServiceImpl implements GenericService<Participacion>{
	
	@Autowired
	private ParticipacionRepository repo;

	@Override
	public List<Participacion> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(Participacion item) {
		repo.save(item);
		
	}

	@Override
	public Participacion findById(Long id) {
		Optional<Participacion> optional = repo.findById(id);
		Participacion s = null;
		
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
