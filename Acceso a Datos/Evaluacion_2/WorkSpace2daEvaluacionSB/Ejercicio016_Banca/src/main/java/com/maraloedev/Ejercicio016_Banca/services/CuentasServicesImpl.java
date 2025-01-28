package com.maraloedev.Ejercicio016_Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio016_Banca.entites.Cuentas;
import com.maraloedev.Ejercicio016_Banca.repositories.CuentasRepository;

@Service
public class CuentasServicesImpl implements GenericService<Cuentas> {

	@Autowired
	private CuentasRepository repo;

	@Override
	public List<Cuentas> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Cuentas item) {
		repo.save(item);

	}

	@Override
	public Cuentas findById(Long id) {

		Optional<Cuentas> optional = repo.findById(id);
		Cuentas b = null;

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
