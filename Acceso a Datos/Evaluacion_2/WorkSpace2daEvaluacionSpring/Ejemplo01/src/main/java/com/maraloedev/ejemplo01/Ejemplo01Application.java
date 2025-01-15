package com.maraloedev.ejemplo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//Significa que estamos configurando la app de forma automatica
@SpringBootApplication
public class Ejemplo01Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Ejemplo01Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo01Application.class, args);
	}

}
