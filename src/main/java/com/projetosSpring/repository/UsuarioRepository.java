package com.projetosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosSpring.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
