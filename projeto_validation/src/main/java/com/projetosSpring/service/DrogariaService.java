package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Drogaria;
import com.projetosSpring.repository.DrogariaRepository;

@Service
public class DrogariaService {

	final private DrogariaRepository DrogariaRepository;
	
	public DrogariaService(DrogariaRepository DrogariaRepository) {
		this.DrogariaRepository = DrogariaRepository;
	}
	
	public Drogaria GetDrogariaById(Long id) {
		return DrogariaRepository.findById(id).orElse(null);
	}
	
	public List<Drogaria> GetAllDrogaria() {
		return DrogariaRepository.findAll();
	}
	

	public Drogaria SaveDrogaria(Drogaria drogaria) {
		return DrogariaRepository.save(drogaria);
	}
	
	public Drogaria updateDrogaria(Long Id, Drogaria updateDrogaria) {
		Optional <Drogaria> drogariaExists = DrogariaRepository.findById(Id);
		if(drogariaExists.isPresent()) {
			updateDrogaria.setId(Id);
			return DrogariaRepository.save(updateDrogaria);
		}
		else {
			return null;
		}
	}
	
	public Boolean deleteDrogaria(Long id) {
		Optional <Drogaria> drogariaExists = DrogariaRepository.findById(id);
		if(drogariaExists.isPresent()) {
			DrogariaRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
