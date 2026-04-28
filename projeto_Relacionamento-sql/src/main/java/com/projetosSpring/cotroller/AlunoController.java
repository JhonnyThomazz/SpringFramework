package com.projetosSpring.cotroller;

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

import com.projetosSpring.entity.Aluno;
import com.projetosSpring.service.AlunoService;

@RestController
@RequestMapping ("/student")

public class AlunoController {

	
	final private AlunoService alunoService;
		
		public AlunoController(AlunoService alunoService) {
			this.alunoService = alunoService;
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity <Aluno> GetAlunoById(@PathVariable Long id){
			Aluno aluno = alunoService.GetAlunoById(id);
			if (aluno != null) {
				return ResponseEntity.ok(aluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@GetMapping ("/")
		public ResponseEntity <List <Aluno>> GetAllAluno(){
			List <Aluno> aluno = alunoService.GetAllAluno();
			return ResponseEntity.ok(aluno);
		}
		
		@PostMapping ("/")
		public ResponseEntity <Aluno> SaveAluno(@RequestBody Aluno aluno){
			Aluno saveAluno = alunoService.SaveAluno(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveAluno);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity <Aluno> UpdateAluno(@PathVariable Long id, @RequestBody Aluno aluno){
			Aluno updateAluno = alunoService.updateAluno(id, aluno);
			if(updateAluno != null) {
				return ResponseEntity.ok(updateAluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity <Aluno> DeleteAluno(@PathVariable Long id){
			boolean deleteAluno = alunoService.DeleteAluno(id);
			if(deleteAluno) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	}
