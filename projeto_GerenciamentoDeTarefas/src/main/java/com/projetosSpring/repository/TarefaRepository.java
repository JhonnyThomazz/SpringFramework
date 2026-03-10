package com.projetosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosSpring.entity.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long>{

}
