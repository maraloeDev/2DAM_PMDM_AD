package com.maraloedev.Ejercicio016_Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio016_Banca.entites.Prestamos;
import com.maraloedev.Ejercicio016_Banca.repositories.PrestamosRepository;

@Service
public class PrestamosServicesImpl implements GenericService<Prestamos> {

	@Autowired
	private PrestamosRepository repo;

	@Override
	public List<Prestamos> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Prestamos item) {
		repo.save(item);

	}

	@Override
	public Prestamos findById(Long id) {

		Optional<Prestamos> optional = repo.findById(id);
		Prestamos c = null;

		if (optional.isPresent()) {
			c = optional.get();
		}
		return c;
	}

	@Override
	public void deletefindById(Long id) {
		repo.deleteById(id);

	}

}
