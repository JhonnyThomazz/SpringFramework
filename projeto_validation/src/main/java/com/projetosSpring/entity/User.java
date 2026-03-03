package com.projetosSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	@Size(min = 0, message="Mínimo de 8 caracteres.")
	private String senha;
	
	@NotNull
	@NotBlank
	@Email(message = "Informe o e-mail corretamente")
	private String email;

	
	public User() {

	}
	
	
	public User(Long id, @NotNull @NotBlank String nome,
			@NotNull @NotBlank @Size(min = 0, message = "Mínimo de 8 caracteres.") String senha,
			@NotNull @NotBlank @Email(message = "Informe o e-mail corretamente") String email) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
