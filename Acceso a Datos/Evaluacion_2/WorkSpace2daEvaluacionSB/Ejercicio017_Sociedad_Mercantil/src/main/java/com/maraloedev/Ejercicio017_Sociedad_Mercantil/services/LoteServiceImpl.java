package com.maraloedev.Ejercicio017_Sociedad_Mercantil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Lote;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Sociedad;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.LoteRepository;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.repositories.SociedadRepository;

@Service
public class LoteServiceImpl implements GenericService<Lote>{
	
	@Autowired
	private LoteRepository repo;

	@Override
	public List<Lote> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Lote item) {
		repo.save(item);
		
	}

	@Override
	public Lote findById(Long id) {
		Optional<Lote> optional = repo.findById(id);
		Lote s = null;
		
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
