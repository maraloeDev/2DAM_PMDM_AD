package com.maraloedev.Ejercicio015_Matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
