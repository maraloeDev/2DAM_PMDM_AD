package com.maraloedev.Ejercicio016_Banca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio016_Banca.entites.Bancos;
import com.maraloedev.Ejercicio016_Banca.services.GenericService;

@RestController
public class BancosController {

	@Autowired
	private GenericService<Bancos> genericService;

	//Lista
	@GetMapping("/bancos")
	public List<Bancos> findAll() {
		return genericService.findAll();
	}
}
