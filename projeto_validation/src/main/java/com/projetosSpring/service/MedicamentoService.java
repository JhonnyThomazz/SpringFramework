package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Medicamento;
import com.projetosSpring.repository.MedicamentoRepository;
@Service
public class MedicamentoService {

final private MedicamentoRepository medicamentoRepository;
	
	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}
	

	public Medicamento getMedicamentoById(Long id) {
		return medicamentoRepository.findById(id).orElse(null);
	}
	
	
	public List<Medicamento> GetAllMedicamento() {
		return medicamentoRepository.findAll();
	}
	

	public Medicamento SaveMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}
	
	public Medicamento updateMedicamento(Long Id, Medicamento updateMedicamento) {
		Optional <Medicamento> medicamentoExists = medicamentoRepository.findById(Id);
		if(medicamentoExists.isPresent()) {
			updateMedicamento.setId(Id);
			return medicamentoRepository.save(updateMedicamento);
		}
		else {
			return null;
		}
	}
	
	public Boolean deleteMedicamento(Long id) {
		Optional <Medicamento> medicamentoExists = medicamentoRepository.findById(id);
		if(medicamentoExists.isPresent()) {
			medicamentoRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
