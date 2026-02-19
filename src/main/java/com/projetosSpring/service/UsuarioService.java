package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Livro;
import com.projetosSpring.entity.Usuario;
import com.projetosSpring.repository.UsuarioRepository;

@Service
public class UsuarioService {

	final private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	//Function_GetById
	public Usuario getUserById(Long Id) {
		return usuarioRepository.findById(Id).orElse(null);
	}
	
	//Function_GetAll
	public List<Usuario> GetAllUser() {
		return usuarioRepository.findAll();
	}
	
	//Function_Save
	public Livro salvarUser(Usuario usuario) {
		return livroRepository.save(livro);
	}
	
	//Function_Update
	public Livro atualizarLivro(Long id, Livro UpdateLivro) {
		Optional <Livro> LivroExists = livroRepository.findById(id);
		if(LivroExists.isPresent()) {
			UpdateLivro.setId(id);
			return livroRepository.save(UpdateLivro);
		}
		else {
			return null;
		}
	}
	
	//Function_Delete
	public Boolean excluirLivro(Long id) {
		Optional<Livro> LivroExists = livroRepository.findById(id);
		if(LivroExists.isPresent()) {
			livroRepository.deleteById(id);
			return true;
		}
		return false;
	}
		
	

	
}
