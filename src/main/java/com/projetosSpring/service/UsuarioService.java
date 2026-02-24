package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public Usuario salvarUser(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//Function_Update
	public Usuario updateUser(Long id, Usuario updateUser) {
		Optional <Usuario> UserExists = usuarioRepository.findById(id);
		if(UserExists.isPresent()) {
			updateUser.setId(id);
			return usuarioRepository.save(updateUser);
		}
		else {
			return null;
		}
	}
	
	//Function_Delete
	public Boolean deleteUser(Long id) {
		Optional<Usuario> UserExists = usuarioRepository.findById(id);
		if(UserExists.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
		
	

	
}
