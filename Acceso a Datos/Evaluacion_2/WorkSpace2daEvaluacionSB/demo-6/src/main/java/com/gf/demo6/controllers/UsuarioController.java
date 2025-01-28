
package com.gf.demo6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gf.demo6.entities.Usuario;
import com.gf.demo6.services.UsuarioService;

@RestController
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuario;  
	
	@GetMapping({"/","/usuarios"})
    public List<Usuario> getAll(){
        //retornará todos las preinscripciones
        return (List<Usuario>) usuario.findAll();
    }
	
	@PostMapping("/insert")
	public void createTitulo(@RequestBody Usuario user) {
		usuario.save(user);
	}
	
	@PutMapping("/update")
	public void updateTitulo(@RequestBody Usuario pre) {
		usuario.save(pre);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTitulo(@PathVariable() Long id) {
		usuario.delete(id);
	}

}
