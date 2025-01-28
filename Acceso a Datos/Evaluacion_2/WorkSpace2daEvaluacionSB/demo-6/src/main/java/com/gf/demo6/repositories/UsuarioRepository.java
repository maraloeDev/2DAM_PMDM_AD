package com.gf.demo6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gf.demo6.entities.Usuario;


public interface UsuarioRepository  extends JpaRepository < Usuario, Long > {

}
