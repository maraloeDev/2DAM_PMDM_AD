package com.maraloedev.Ejercicio018_Skills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.entities.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Long> {

}
