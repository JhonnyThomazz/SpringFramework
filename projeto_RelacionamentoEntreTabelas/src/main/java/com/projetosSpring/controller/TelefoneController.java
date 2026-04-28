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

import com.projetosSpring.entity.Telefone;
import com.projetosSpring.service.TelefoneService;

@RestController
@RequestMapping ("/tel")
public class TelefoneController {

final private TelefoneService telefoneService;
	
	public TelefoneController(TelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Telefone> GetTelefoneById(@PathVariable Long id){
		Telefone telefone = telefoneService.GetTelefoneById(id);
		if (telefone != null) {
			return ResponseEntity.ok(telefone);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping ("/")
	public ResponseEntity <List <Telefone>> GetAllTelefone(){
		List <Telefone> telefone = telefoneService.GetAllTelefone();
		return ResponseEntity.ok(telefone);
	}
	
	@PostMapping ("/")
	public ResponseEntity <Telefone> SaveTelefone(@RequestBody Telefone telefone){
		Telefone saveTelefone = telefoneService.SaveTelefone(telefone);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTelefone);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Telefone> UpdateTelefone(@PathVariable Long id, @RequestBody Telefone telefone){
		Telefone updateTelefone = telefoneService.UpdateTelefone(id, telefone);
		if(updateTelefone != null) {
			return ResponseEntity.ok(updateTelefone);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Telefone> DeleteTelefone(@PathVariable Long id){
		boolean deleteTelefone = telefoneService.DeleteTelefone(id);
		if(deleteTelefone) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
