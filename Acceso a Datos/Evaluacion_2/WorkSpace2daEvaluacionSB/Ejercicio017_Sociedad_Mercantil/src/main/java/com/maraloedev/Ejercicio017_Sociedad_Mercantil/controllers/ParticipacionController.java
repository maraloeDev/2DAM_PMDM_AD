package com.maraloedev.Ejercicio017_Sociedad_Mercantil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Participacion;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.services.GenericService;

@RestController
public class ParticipacionController {
	
	@Autowired
	private GenericService<Participacion> gs;
	
	@PostMapping("/participacion")
	public void crearParticipacion(@RequestBody Participacion participacion) {
		gs.save(participacion);
	}
	
	@GetMapping("/participaciones")
	public List<Participacion> buscarParticipaciones() {
		return gs.findAll();
	}
	
	@DeleteMapping("/participacion({id}")
	public void borrarParticipacion(@PathVariable Long id) {
		gs.deleteById(id);
	}
}
