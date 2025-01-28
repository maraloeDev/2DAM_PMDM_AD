package com.gf.demo3;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonaController {
	
	@GetMapping("/lista")
	public String lista(Model modelo) {
		Persona p1 = new Persona("ruth", "fernandez", 44);
		Persona p2 = new Persona("sergio", "lópez", 20);
		Persona p3 = new Persona("pablo", "casas", 35);
		List<Persona> personas = Arrays.asList(p1, p2, p3);
		modelo.addAttribute(personas);
		return "lista";

	}

}
