package com.maraloedev.Ejercicio018_Skills.services;

import java.util.List;

public interface GenerateService <T> {
	
	List<T> findAll();
	
	void save(T item);
	
	T findById(Long id);
	
	void deleteById(Long id);

}
