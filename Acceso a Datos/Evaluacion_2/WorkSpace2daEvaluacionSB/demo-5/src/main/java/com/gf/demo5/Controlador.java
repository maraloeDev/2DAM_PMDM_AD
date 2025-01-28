package com.gf.demo5;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
	
	@GetMapping(value="/index", produces=MediaType.TEXT_PLAIN_VALUE)
	//@GetMapping(value="/index", produces=MediaType.TEXT_HTML_VALUE)
	public String Page() {
		return "<h2>HOLA MUNDO SPRING</h2>";

	}

}
