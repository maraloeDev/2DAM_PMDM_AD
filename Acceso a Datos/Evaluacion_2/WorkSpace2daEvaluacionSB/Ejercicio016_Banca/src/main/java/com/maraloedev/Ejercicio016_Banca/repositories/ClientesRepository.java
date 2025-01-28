package com.maraloedev.Ejercicio016_Banca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.Ejercicio016_Banca.entites.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
