package com.gf.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaControlador {
	@GetMapping ({"/","/hola"})
	public String mostrarPagina() {
		return "hola";
	}

}
