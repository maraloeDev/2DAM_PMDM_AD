package com.dam.demo_init;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class Controladora {

	@GetMapping({ "/", "/index" })

	public String saludo() {
		return "index";
	}
}
