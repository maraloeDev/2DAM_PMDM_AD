package com.maraloedev.Ejercicio015_Matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.Ejercicio015_Matriculas.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
