package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Livro;
import com.projetosSpring.repository.LivroRepository;

@Service
public class LivroService {

	final private LivroRepository livroRepository;

	//Link
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	//Function_GetById
	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	//Function_GetAll
	public List<Livro> getAllLivros(){
		return livroRepository.findAll();
	}
	
	//Function_Save
	public Livro salvarLivro(Livro livro) {
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
