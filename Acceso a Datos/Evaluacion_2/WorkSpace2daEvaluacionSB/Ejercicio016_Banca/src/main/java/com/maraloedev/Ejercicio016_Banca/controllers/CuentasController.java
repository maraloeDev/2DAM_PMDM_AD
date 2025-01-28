package com.maraloedev.Ejercicio016_Banca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maraloedev.Ejercicio016_Banca.entites.Cuentas;
import com.maraloedev.Ejercicio016_Banca.services.GenericService;

@RestController
public class CuentasController {

	@Autowired
	private GenericService<Cuentas> genericService;

	// Crear
	 @PostMapping("/cuenta")
	public void insert(@RequestBody Cuentas cuentas) {
			genericService.save(cuentas);
	}
}
