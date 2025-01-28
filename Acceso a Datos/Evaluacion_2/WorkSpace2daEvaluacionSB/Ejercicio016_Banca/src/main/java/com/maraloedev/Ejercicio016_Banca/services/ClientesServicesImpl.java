package com.maraloedev.Ejercicio016_Banca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.Ejercicio016_Banca.entites.Clientes;
import com.maraloedev.Ejercicio016_Banca.repositories.ClientesRepository;

@Service
public class ClientesServicesImpl implements GenericService<Clientes> {

	@Autowired
	private ClientesRepository repo;

	@Override
	public List<Clientes> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Clientes item) {
		repo.save(item);

	}

	@Override
	public Clientes findById(Long id) {

		Optional<Clientes> optional = repo.findById(id);
		Clientes c = null;

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
