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

import com.maraloedev.Ejercicio018_Skills.entities.Tutor;
import com.maraloedev.Ejercicio018_Skills.services.GenerateService;

@RestController
public class TutorController {
	
	@Autowired
	private GenerateService<Tutor> gs;
	
	//GET
	@GetMapping("/tutores")
	public List<Tutor> findAll() {
		return gs.findAll();
	}
	//POST
	@PostMapping("/tutor")
	public void insertarModalidad(@RequestBody Tutor tutor) {
		gs.save(tutor);
	}
	
	//PUT
	@PutMapping("/tutor/{id}")
	public void actualizarModalidad(@RequestBody Tutor tutor, @PathVariable Long id) {
		gs.save(tutor);
	}
	
	//BUSCAR
	@GetMapping("/tutor/{id}")
		public void buscarTutor(@PathVariable Long id) {
			gs.findById(id);
			
		}
		
	//DELETE
	@DeleteMapping("/tutor/{id}")
	public void eliminarTutor(@PathVariable Long id) {
		gs.deleteById(id);
		
	}
	

}
