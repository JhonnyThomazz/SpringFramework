package com.projetosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosSpring.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
