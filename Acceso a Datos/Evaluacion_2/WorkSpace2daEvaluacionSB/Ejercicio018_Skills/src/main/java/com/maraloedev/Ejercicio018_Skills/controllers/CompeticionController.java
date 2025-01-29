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
import com.maraloedev.Ejercicio018_Skills.entities.Competicion;
import com.maraloedev.Ejercicio018_Skills.services.GenerateService;

@RestController
public class CompeticionController {
	
	@Autowired
	private GenerateService<Competicion> gs;
	
	//GET
	@GetMapping("/competiciones")
	public List<Competicion> findAll() {
		return gs.findAll();
	}
	//POST
	@PostMapping("/competicion")
	public void insertarCompeticion(@RequestBody Competicion competicion) {
		gs.save(competicion);
	}
	
	//PUT
	@PutMapping("/competicion/{id}")
	public void actualizarCompeticion(@RequestBody Competicion competicion, @PathVariable Long id) {
		gs.save(competicion);
	}
	
	//BUSCAR
	@GetMapping("/competicion/{id}")
		public void buscarCompeticion(@PathVariable Long id) {
			gs.findById(id);
			
		}
		
	//DELETE
	@DeleteMapping("/competicion/{id}")
	public void eliminarCompeticion(@PathVariable Long id) {
		gs.deleteById(id);
		
	}
	

}
