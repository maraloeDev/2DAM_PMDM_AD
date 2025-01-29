package com.maraloedev.Ejercicio018_Skills.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio018_Skills.entities.Premios;
import com.maraloedev.Ejercicio018_Skills.services.GenerateService;

@RestController
public class PremiosController {
	
	@Autowired
	private GenerateService<Premios> gs;
	
	//GET
	@GetMapping("/premios")
	public List<Premios> findAll() {
		return gs.findAll();
	}
	//POST
	@PostMapping("/premios")
	public void insertarPremios(@RequestBody Premios premios) {
		gs.save(premios);
	}
	
	//PUT
	@PutMapping("/premio/{id}")
	public void actualizarPremios(@RequestBody Premios premios, @PathVariable Long id) {
		gs.save(premios);
	}
	
	//BUSCAR
	@GetMapping("/premio/{id}")
		public void buscarPremios(@PathVariable Long id) {
			gs.findById(id);
			
		}
		
	//DELETE
	@DeleteMapping("/premio/{id}")
	public void eliminarPremios(@PathVariable Long id) {
		gs.deleteById(id);
		
	}
	

}
