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

import com.projetosSpring.entity.Cliente;
import com.projetosSpring.service.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	final private ClienteService clienteService;
	
	private ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Cliente> getClienteById(@PathVariable Long id){
		Cliente cliente = clienteService.getClienteById(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		}
		else {
			return ResponseEntity.notFound().build();		
		}
	}
	
	@GetMapping("/")
	public ResponseEntity <List <Cliente>> getAllCliente(){
		List <Cliente> cliente = clienteService.getAllCliente();
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/")
	public ResponseEntity <Cliente> saveCliente(@RequestBody Cliente cliente){
		Cliente saveCliente = clienteService.saveCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
		Cliente updateCliente = clienteService.updateCliente(id, cliente);
		if(updateCliente != null) {
			return ResponseEntity.ok(updateCliente);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Cliente> deleteCliente(@PathVariable Long id){
		boolean deleteCliente = clienteService.deleteCliente(id);
		if(deleteCliente) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
