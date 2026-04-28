package com.projetosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosSpring.entity.Pessoa;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{

}
