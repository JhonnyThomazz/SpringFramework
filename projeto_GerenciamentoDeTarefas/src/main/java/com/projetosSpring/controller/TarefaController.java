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

import com.projetosSpring.entity.Tarefa;
import com.projetosSpring.service.TarefaService;

@RestController
@RequestMapping("/Tarefa")
public class TarefaController {

	final private TarefaService tarefaService;
	
	private TarefaController (TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id){
		Tarefa tarefa = tarefaService.GetTarefaById(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Tarefa>> getAllTarefa(){
		List<Tarefa> tarefa = tarefaService.GetAllTarefas();
		return ResponseEntity.ok(tarefa);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefa){
		Tarefa saveTarefa = tarefaService.SaveTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTarefa);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa){
		Tarefa updateTarefa = tarefaService.UpdateTarefa(id, tarefa);
		if (updateTarefa != null) {
			return ResponseEntity.ok(updateTarefa);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Tarefa> deleteTarefa(@PathVariable Long id) {
		boolean deleteTarefa = tarefaService.deleteTarefa(id);
		if(deleteTarefa) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}	
}
