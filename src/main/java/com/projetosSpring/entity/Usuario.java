package com.projetosSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private int senha;

	@Column
	private String permissao;

	@Column
	private String usuario;
	// Tipo_de_user: ADM, Bibliotecario_e_Cliente.

	// Constructor_EMPTY
	public Usuario() {

	}

	// Constructor.
	public Usuario(Long id, String nome, int senha, String permissao, String usuario) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.permissao = permissao;
		this.usuario = usuario;
	}

	// GettersAndSetters.
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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
