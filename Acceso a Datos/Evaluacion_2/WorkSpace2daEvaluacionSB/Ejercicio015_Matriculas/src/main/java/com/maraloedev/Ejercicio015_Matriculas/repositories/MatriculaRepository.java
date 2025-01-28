package com.maraloedev.Ejercicio015_Matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;
import com.maraloedev.Ejercicio015_Matriculas.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
