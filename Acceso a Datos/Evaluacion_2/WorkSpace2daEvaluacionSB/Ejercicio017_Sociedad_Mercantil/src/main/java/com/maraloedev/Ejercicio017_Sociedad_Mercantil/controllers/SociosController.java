package com.maraloedev.Ejercicio017_Sociedad_Mercantil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Socio;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.services.GenericService;

@RestController
public class SociosController {
	
	@Autowired
	private GenericService<Socio> gs;
	
	@PostMapping("/socio")
	public void crearSocio(@RequestBody Socio socio) {
		gs.save(socio);
	}
	
	@GetMapping("/socios")
	public List<Socio> buscarSocios() {
		return gs.findAll();
	}
	
	@GetMapping("/socio/{id}")
	public Socio buscarSocio(@PathVariable Long id) {
		return gs.findById(id);
	}
	
	@DeleteMapping("/socio/{id}")
	public void eliminarSocio(@PathVariable Long id) {
		gs.deleteById(id);
	}
	
	@PutMapping("/socio/{id}")
	public void actualizarSocio(@RequestBody Socio socio, @PathVariable Long id) {
		gs.save(socio);
	}
}
