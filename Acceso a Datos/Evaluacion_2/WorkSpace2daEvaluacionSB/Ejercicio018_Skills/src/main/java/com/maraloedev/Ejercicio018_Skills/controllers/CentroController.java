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

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.services.GenerateService;

@RestController
public class CentroController {
	
	@Autowired
	private GenerateService<Centro> gs;
	
	//GET
	@GetMapping("/centros")
	public List<Centro> findAll() {
		return gs.findAll();
	}
	//POST
	@PostMapping("/centro")
	public void insertarCentros(@RequestBody Centro centro) {
		gs.save(centro);
	}
	
	//PUT
	@PutMapping("/centro/{id}")
	public void actualizarCentros(@RequestBody Centro centro, @PathVariable Long id) {
		gs.save(centro);
	}
	
	//BUSCAR
		@GetMapping("/centro/{id}")
		public void buscarCentro(@PathVariable Long id) {
			gs.findById(id);
			
		}
		
	//DELETE
	@DeleteMapping("/centro/{id}")
	public void eliminarCentro(@PathVariable Long id) {
		gs.deleteById(id);
		
	}
	

}
