package com.maraloedev;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model; // Asegúrate de importar esta clase

@Controller
public class PersonaController {
	
	@GetMapping({"/", "/lista2"})
	public String lista(Model modelo) {
		Persona persona1 = new Persona("Juan", "Perez", 30);
		Persona persona2 = new Persona("Maria", "Lopez", 25);
		Persona persona3 = new Persona("Carlos", "Gonzalez", 40);
		
		List<Persona> personas = new ArrayList<>();
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		
		// Agregar la lista de personas al modelo con una clave
		modelo.addAttribute("personas", personas);
		return "lista2";
	}
}
