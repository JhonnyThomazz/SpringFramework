package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Telefone;
import com.projetosSpring.repository.TelefoneRepository;

@Service
public class TelefoneService {

	final private TelefoneRepository telefoneRepository;
		
	private TelefoneService (TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}
	
	public Telefone GetTelefoneById(Long id) {
		return telefoneRepository.findById(id).orElse(null);
	}
	
	public List<Telefone> GetAllTelefone() {
		return telefoneRepository.findAll();
	}
	
	public Telefone SaveTelefone(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
	public Telefone UpdateTelefone(Long id, Telefone updateTelefone) {
		Optional <Telefone> TelefoneExists = telefoneRepository.findById(id);
		if(TelefoneExists.isPresent()) {
			updateTelefone.setId(id);
			return telefoneRepository.save(updateTelefone);
		}
		else {
			return null;
		}
	}
	
	public Boolean DeleteTelefone(Long id) {
		Optional <Telefone> telefoneExists = telefoneRepository.findById(id);
		if(telefoneExists.isPresent()) {
			telefoneRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
