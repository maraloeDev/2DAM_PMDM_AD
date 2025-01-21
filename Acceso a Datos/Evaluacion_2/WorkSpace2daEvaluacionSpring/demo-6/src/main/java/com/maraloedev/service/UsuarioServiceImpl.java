package com.maraloedev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maraloedev.entities.Usuario;
import com.maraloedev.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired // Inyectar el repositorio, sin usar new
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public void save(Usuario user) {
		// TODO Auto-generated method stub
		
		usuarioRepository.save(user);
		
	}

	@Override
	public Usuario findById(long id) {
		// TODO Auto-generated method stub
		
		//Objeto para saber si el usuario existe o no
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		}	
            return null; 
		}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
		
	}

}
