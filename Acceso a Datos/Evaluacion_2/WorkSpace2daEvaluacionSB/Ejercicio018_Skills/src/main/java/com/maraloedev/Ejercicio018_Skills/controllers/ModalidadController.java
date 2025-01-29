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
import com.maraloedev.Ejercicio018_Skills.entities.Modalidad;
import com.maraloedev.Ejercicio018_Skills.services.GenerateService;

@RestController
public class ModalidadController {
	
	@Autowired
	private GenerateService<Modalidad> gs;
	
	//GET
	@GetMapping("/modalidades")
	public List<Modalidad> findAll() {
		return gs.findAll();
	}
	//POST
	@PostMapping("/modalidad")
	public void insertarModalidad(@RequestBody Modalidad modalidad) {
		gs.save(modalidad);
	}
	
	//PUT
	@PutMapping("/modalidad/{id}")
	public void actualizarModalidad(@RequestBody Modalidad modalidad, @PathVariable Long id) {
		gs.save(modalidad);
	}
	
	//BUSCAR
	@GetMapping("/modalidad/{id}")
		public void buscarModalidad(@PathVariable Long id) {
			gs.findById(id);
			
		}
		
	//DELETE
	@DeleteMapping("/modalidad/{id}")
	public void eliminarModalidad(@PathVariable Long id) {
		gs.deleteById(id);
		
	}
	

}
