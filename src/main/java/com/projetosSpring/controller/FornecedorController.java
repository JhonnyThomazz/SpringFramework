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

import com.projetosSpring.entity.Fornecedor;
import com.projetosSpring.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

	private final FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}
	
	//Function_GetById
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> getSupplierById(@PathVariable Long id){
		Fornecedor fornecedor = fornecedorService.getSupplierById(id);
		if (fornecedor != null) {
			return ResponseEntity.ok(fornecedor);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Function_GetAll
	@GetMapping("/")
	public ResponseEntity<List<Fornecedor>> getAllSupplier(){
		List<Fornecedor> fornecedor = fornecedorService.GetAllSupplier();
		return ResponseEntity.ok(fornecedor);
	}
	
	//Function_Save
	@PostMapping("/")
	public ResponseEntity<Fornecedor> saveSupplier(@RequestBody Fornecedor fornecedor){
		Fornecedor saveSupplier = fornecedorService.salvarSupplier(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveSupplier);
	}
	
	//Function_Update
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> updateSupplier(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
		Fornecedor updateSupplier = fornecedorService.updateSupplier(id, fornecedor);
		if (updateSupplier != null) {
			return ResponseEntity.ok(updateSupplier);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	//Function_Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Fornecedor> deleteSupplier(@PathVariable Long id) {
		boolean deleteSupplier = fornecedorService.deleteSupplier(id);
		if(deleteSupplier) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
		
	
}
