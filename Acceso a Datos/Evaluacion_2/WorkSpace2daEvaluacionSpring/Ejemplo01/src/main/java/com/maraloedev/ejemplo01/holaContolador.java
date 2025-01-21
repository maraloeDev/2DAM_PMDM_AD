package com.maraloedev.ejemplo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class holaContolador {
	//La barra el para iniciar la solicitud de peticion
	@GetMapping({"/", "/hola" })
	
	public String mostrarPagina() {
		return "hola";
	}

}
