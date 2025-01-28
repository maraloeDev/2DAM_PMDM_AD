package com.gf.demo4;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonaController {

	@GetMapping("/lista")
	public String lista(Model modelo) {

		Persona p1 = new Persona("noel", "prieto", 20);
		Persona p2 = new Persona("sergio", "otero", 30);
		Persona p3 = new Persona("lucía", "garcía", 40);

		List<Persona> personas = Arrays.asList(p1, p2, p3);
		modelo.addAttribute("personas", personas);
		//return "lista";
		return "lista2";

	}
}


