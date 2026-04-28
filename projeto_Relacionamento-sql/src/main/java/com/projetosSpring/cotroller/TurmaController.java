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

import com.projetosSpring.entity.Turma;
import com.projetosSpring.service.TurmaService;


@RestController
@RequestMapping ("/classroom")

public class TurmaController {

	
	final private TurmaService turmaService;
		
		public TurmaController(TurmaService turmaService) {
			this.turmaService = turmaService;
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity <Turma> GetTurmaById(@PathVariable Long id){
			Turma turma = turmaService.GetTurmaById(id);
			if (turma != null) {
				return ResponseEntity.ok(turma);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@GetMapping ("/")
		public ResponseEntity <List <Turma>> GetAllTurma(){
			List <Turma> turma = turmaService.GetAllTurma();
			return ResponseEntity.ok(turma);
		}
		
		@PostMapping ("/")
		public ResponseEntity <Turma> SaveTurma(@RequestBody Turma turma){
			Turma saveTurma = turmaService.SaveTurma(turma);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveTurma);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity <Turma> UpdateTurma(@PathVariable Long id, @RequestBody Turma turma){
			Turma updateTurma = turmaService.updateTurma(id, turma);
			if(updateTurma != null) {
				return ResponseEntity.ok(updateTurma);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity <Turma> DeleteTurma(@PathVariable Long id){
			boolean deleteTurma = turmaService.DeleteTurma(id);
			if(deleteTurma) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	}
