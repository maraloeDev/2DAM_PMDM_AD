package com.maraloedev;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	//@GetMapping(value = "/index", produces = MediaType.TEXT_PLAIN_VALUE)
	@GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
	public String page() {
		return "<h1>Hola Mundo Spring</h1>";
	}

}
