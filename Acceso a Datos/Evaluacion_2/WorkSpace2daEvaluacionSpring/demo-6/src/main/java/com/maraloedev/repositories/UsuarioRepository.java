package com.maraloedev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maraloedev.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
