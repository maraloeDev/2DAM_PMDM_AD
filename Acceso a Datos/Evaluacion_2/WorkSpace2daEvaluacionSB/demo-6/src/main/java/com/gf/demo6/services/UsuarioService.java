package com.gf.demo6.services;

import java.util.List;

import com.gf.demo6.entities.Usuario;



public interface UsuarioService {
	
    List<Usuario> findAll();
 	
	void save(Usuario user);

	Usuario findById(Long id);

	void delete(Long id);

		

	}


