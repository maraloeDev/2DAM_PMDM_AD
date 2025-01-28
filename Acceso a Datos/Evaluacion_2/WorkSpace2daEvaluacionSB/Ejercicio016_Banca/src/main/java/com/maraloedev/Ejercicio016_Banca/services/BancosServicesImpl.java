package com.maraloedev.Ejercicio016_Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio016_Banca.entites.Bancos;
import com.maraloedev.Ejercicio016_Banca.repositories.BancosRepository;

@Service
public class BancosServicesImpl implements GenericService<Bancos> {

	@Autowired
	private BancosRepository repo;

	@Override
	public List<Bancos> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Bancos item) {
		repo.save(item);

	}

	@Override
	public Bancos findById(Long id) {

		Optional<Bancos> optional = repo.findById(id);
		Bancos b = null;

		if (optional.isPresent()) {
			b = optional.get();
		}
		return b;
	}

	@Override
	public void deletefindById(Long id) {
		repo.deleteById(id);

	}

}
