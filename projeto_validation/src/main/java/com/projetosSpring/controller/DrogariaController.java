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

import com.projetosSpring.entity.Drogaria;
import com.projetosSpring.service.DrogariaService;

@RestController
@RequestMapping("/Drogaria")
public class DrogariaController {

	private final DrogariaService drogariaService;

	public DrogariaController(DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Drogaria> getDrogariaById(@PathVariable Long id){
		Drogaria drogaria = drogariaService.GetDrogariaById(id);
		if (drogaria != null) {
			return ResponseEntity.ok(drogaria);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Drogaria>> getAllDrogaria(){
		List<Drogaria> drogaria = drogariaService.GetAllDrogaria();
		return ResponseEntity.ok(drogaria);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Drogaria> saveDrogaria(@RequestBody Drogaria drogaria){
		Drogaria saveDrogaria = drogariaService.SaveDrogaria(drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveDrogaria);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Drogaria> updateDrogaria(@PathVariable Long id, @RequestBody Drogaria drogaria){
		Drogaria updateDrogaria = drogariaService.updateDrogaria(id, drogaria);
		if (updateDrogaria != null) {
			return ResponseEntity.ok(updateDrogaria);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Drogaria> deleteDrogaria(@PathVariable Long id) {
		boolean deleteDrogaria = drogariaService.deleteDrogaria(id);
		if(deleteDrogaria) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
