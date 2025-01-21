package com.maraloedev.ejemplo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Controlador {
	
	@GetMapping({"/" ,"/index"})
	public String viewPage(HttpServletRequest request) {
		request.setAttribute("nombre", "Eduardo");
		request.setAttribute("grupo", "2º DAM");
		return "index";
	}

}
