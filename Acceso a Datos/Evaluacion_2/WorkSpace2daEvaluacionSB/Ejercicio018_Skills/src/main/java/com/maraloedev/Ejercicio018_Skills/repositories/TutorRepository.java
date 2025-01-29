package com.maraloedev.Ejercicio018_Skills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.Ejercicio018_Skills.entities.Centro;
import com.maraloedev.Ejercicio018_Skills.entities.Competicion;
import com.maraloedev.Ejercicio018_Skills.entities.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
