package com.gf.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HolaControlador {
	@GetMapping("/index")
	public String viewPage(HttpServletRequest request) {
		request.setAttribute("nombre", "ruth");
		request.setAttribute("grupo", "2DAM");
		
		return "index";
	}

}
