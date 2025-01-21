package com.maraloedev.service;

import java.util.List;

import com.maraloedev.entities.Usuario;


public interface UsuarioService {

	List<Usuario> findAll();
	
	void save(Usuario user);
	
	Usuario findById(long id);
	
	void deleteById(long id);
}
