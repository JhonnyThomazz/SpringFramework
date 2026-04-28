package com.projetosSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="student")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	

	@NotNull
	@NotBlank	
	private String ra;

	@NotNull
	@NotBlank	
	private String cidade;
	

	@NotNull
	@NotBlank	
	private String email;
	

	@NotNull
	@NotBlank	
	private String telefone;
	

	@NotNull	
	private double renda;
	
	@ManyToOne
	@JoinColumn (name = "id_turma")
	private Turma turma;

}
