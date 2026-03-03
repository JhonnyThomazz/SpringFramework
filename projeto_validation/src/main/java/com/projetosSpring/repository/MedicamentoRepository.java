package com.projetosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosSpring.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

}
