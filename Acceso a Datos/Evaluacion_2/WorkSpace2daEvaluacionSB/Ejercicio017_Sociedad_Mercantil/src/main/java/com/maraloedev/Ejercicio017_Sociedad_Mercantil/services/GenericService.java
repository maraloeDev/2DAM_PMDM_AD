package com.maraloedev.Ejercicio017_Sociedad_Mercantil.services;

import java.util.List;

public interface GenericService<T> {
	
	//Lista
	List<T> findAll();
	
	//Agrega
	void save(T item);
	
	//Busca
	T findById(Long id);
	
	//Elimina
	void deleteById(Long id);
}
