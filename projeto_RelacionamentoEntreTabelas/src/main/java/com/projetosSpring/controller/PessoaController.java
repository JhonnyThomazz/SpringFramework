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

import com.projetosSpring.entity.Pessoa;
import com.projetosSpring.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	final private PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Pessoa> GetPessoaById(@PathVariable Long id){
		Pessoa pessoa = pessoaService.GetPessoaById(id);
		if (pessoa != null) {
			return ResponseEntity.ok(pessoa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping ("/")
	public ResponseEntity <List <Pessoa>> GetAllPessoa(){
		List <Pessoa> pessoa = pessoaService.GetAllPessoa();
		return ResponseEntity.ok(pessoa);
	}
	
	@PostMapping ("/")
	public ResponseEntity <Pessoa> SavePessoa(@RequestBody Pessoa pessoa){
		Pessoa savePessoa = pessoaService.SavePessoa(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(savePessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Pessoa> UpdatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
		Pessoa updatePessoa = pessoaService.UpdatePessoa(id, pessoa);
		if(updatePessoa != null) {
			return ResponseEntity.ok(updatePessoa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Pessoa> DeletePessoa(@PathVariable Long id){
		boolean deletePessoa = pessoaService.DeletePessoa(id);
		if(deletePessoa) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
