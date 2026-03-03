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

import com.projetosSpring.entity.User;
import com.projetosSpring.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user = userService.getUserById(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user = userService.GetAllUser();
		return ResponseEntity.ok(user);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User saveUser = userService.SaveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		User updateUser = userService.updateUser(id, user);
		if (updateUser != null) {
			return ResponseEntity.ok(updateUser);
		}
		else {
			return ResponseEntity.notFound().build();		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		boolean deleteUser = userService.deleteUser(id);
		if(deleteUser) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
