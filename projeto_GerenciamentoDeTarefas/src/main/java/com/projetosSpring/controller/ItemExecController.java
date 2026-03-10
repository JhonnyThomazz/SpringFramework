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

import com.projetosSpring.entity.ItemExecucao;
import com.projetosSpring.service.ItemExecService;

@RestController
@RequestMapping("/itemExec")
public class ItemExecController {
	
	final private ItemExecService itemExecService;
	
	private ItemExecController(ItemExecService itemExecService) {
		this.itemExecService = itemExecService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemExecucao> getItemExecucaoById(@PathVariable Long id){
		ItemExecucao itemExec = itemExecService.GetItemExecucaoById(id);
		if (itemExec != null) {
			return ResponseEntity.ok(itemExec);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<ItemExecucao>> getAllItemExecucao(){
		List<ItemExecucao> itemExec = itemExecService.GetAllItemExecucaos();
		return ResponseEntity.ok(itemExec);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<ItemExecucao> saveItemExecucao(@RequestBody ItemExecucao itemExec){
		ItemExecucao saveItemExecucao = itemExecService.SaveItemExecucao(itemExec);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveItemExecucao);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemExecucao> updateItemExecucao(@PathVariable Long id, @RequestBody ItemExecucao itemExec){
		ItemExecucao updateItemExecucao = itemExecService.UpdateItemExecucao(id, itemExec);
		if (updateItemExecucao != null) {
			return ResponseEntity.ok(updateItemExecucao);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ItemExecucao> deleteItemExecucao(@PathVariable Long id) {
		boolean deleteItemExecucao = itemExecService.deleteItemExecucao(id);
		if(deleteItemExecucao) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
