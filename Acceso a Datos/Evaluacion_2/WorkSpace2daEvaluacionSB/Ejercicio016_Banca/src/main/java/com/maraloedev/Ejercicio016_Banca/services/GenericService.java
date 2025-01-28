package com.maraloedev.Ejercicio016_Banca.services;

import java.util.List;

public interface GenericService<T> {
	
	List<T> findAll();
	
	void save(T item);
	
	T findById(Long id);
	
	void deletefindById(Long id);

}
