package com.maraloedev.Ejercicio017_Sociedad_Mercantil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio017_Sociedad_Mercantil.entities.Sociedad;
import com.maraloedev.Ejercicio017_Sociedad_Mercantil.services.GenericService;

@RestController
public class SociedadController {
	
	@Autowired
	private GenericService<Sociedad> gs;
	
	@PostMapping("/sociedad")
	public void crearSociedad(@RequestBody Sociedad sociedad) {
		gs.save(sociedad);
	}
}
