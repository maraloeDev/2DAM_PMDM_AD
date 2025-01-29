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

import com.maraloedev.Ejercicio018_Skills.entities.Participante;
import com.maraloedev.Ejercicio018_Skills.services.GenerateService;

@RestController
public class ParticipanteController {
	
	@Autowired
	private GenerateService<Participante> gs;
	
	//GET
	@GetMapping("/participantes")
	public List<Participante> findAll() {
		return gs.findAll();
	}
	//POST
	@PostMapping("/participante")
	public void insertarParticipante(@RequestBody Participante participante) {
		gs.save(participante);
	}
	
	//PUT
	@PutMapping("/participante/{id}")
	public void actualizarParticipante(@RequestBody Participante participante, @PathVariable Long id) {
		gs.save(participante);
	}
	
	//BUSCAR
	@GetMapping("/participante/{id}")
		public void buscarParticipante(@PathVariable Long id) {
			gs.findById(id);
			
		}
		
	//DELETE
	@DeleteMapping("/participante/{id}")
	public void eliminarParticipante(@PathVariable Long id) {
		gs.deleteById(id);
		
	}
}
