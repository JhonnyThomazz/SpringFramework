package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Turma;
import com.projetosSpring.repository.TurmaRepository;

@Service
public class TurmaService {

	final private TurmaRepository turmaRepository;
	
	private TurmaService (TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	public Turma GetTurmaById(Long id) {
		return turmaRepository.findById(id).orElse(null);
	}
	
	public List<Turma> GetAllTurma() {
		return turmaRepository.findAll();
	}
	
	public Turma SaveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma updateTurma(Long id, Turma turma) {
		Optional<Turma> existPerson = turmaRepository.findById(id);
		if (existPerson.isPresent()) {
			Turma updatePerson = existPerson.get();
			BeanUtils.copyProperties(turma, updatePerson, "id");
			return turmaRepository.save(updatePerson);
		}
		
		return null;
	}
	
	public Boolean DeleteTurma(Long id) {
		Optional <Turma> turmaExists = turmaRepository.findById(id);
		if(turmaExists.isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}