package com.projetosSpring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosSpring.entity.Medicamento;
import com.projetosSpring.service.MedicamentoService;

@RestController
@RequestMapping("/Medicamento")
public class MedicamentoController {

	private final MedicamentoService medicamentoService;

	public MedicamentoController(MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id){
		Medicamento medicamento = medicamentoService.getMedicamentoById(id);
		if (medicamento != null) {
			return ResponseEntity.ok(medicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Medicamento>> getAllMedicamento(){
		List<Medicamento> medicamento = medicamentoService.GetAllMedicamento();
		return ResponseEntity.ok(medicamento);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Medicamento> saveMedicamento(@RequestBody Medicamento medicamento){
		Medicamento saveMedicamento = medicamentoService.SaveMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveMedicamento);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento){
		Medicamento updateMedicamento = medicamentoService.updateMedicamento(id, medicamento);
		if (updateMedicamento != null) {
			return ResponseEntity.ok(updateMedicamento);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medicamento> deleteMedicamento(@PathVariable Long id) {
		boolean deleteMedicamento = medicamentoService.deleteMedicamento(id);
		if(deleteMedicamento) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
