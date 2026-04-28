package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Aluno;
import com.projetosSpring.repository.AlunoRepository;

@Service
public class AlunoService {

	final private AlunoRepository alunoRepository;
	
	private AlunoService (AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno GetAlunoById(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public List<Aluno> GetAllAluno() {
		return alunoRepository.findAll();
	}
	
	public Aluno SaveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno updateAluno(Long id, Aluno aluno) {
		Optional<Aluno> existPerson = alunoRepository.findById(id);
		if (existPerson.isPresent()) {
			Aluno updatePerson = existPerson.get();
			BeanUtils.copyProperties(aluno, updatePerson, "id");
			return alunoRepository.save(updatePerson);
		}
		
		return null;
	}
	
	public Boolean DeleteAluno(Long id) {
		Optional <Aluno> alunoExists = alunoRepository.findById(id);
		if(alunoExists.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
