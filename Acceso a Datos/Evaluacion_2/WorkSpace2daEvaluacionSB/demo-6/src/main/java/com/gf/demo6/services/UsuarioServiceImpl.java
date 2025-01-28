package com.gf.demo6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.demo6.entities.Usuario;
import com.gf.demo6.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
    
	@Override
	public void save(Usuario user) {
		usuarioRepository.save(user);
	}

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> userResult = usuarioRepository.findById(id);
		Usuario u = null;
		if (userResult.isPresent()) {
			u = userResult.get();
			
		} 
		return u;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

}