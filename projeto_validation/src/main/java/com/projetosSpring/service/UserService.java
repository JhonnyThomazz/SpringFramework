package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.User;
import com.projetosSpring.repository.UserRepository;

@Service
public class UserService {

	final private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	

	public List<User> GetAllUser() {
		return userRepository.findAll();
	}
	

	public User SaveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(Long Id, User updateUser) {
		Optional <User> userExists = userRepository.findById(Id);
		if(userExists.isPresent()) {
			updateUser.setId(Id);
			return userRepository.save(updateUser);
		}
		else {
			return null;
		}
	}
	
	public Boolean deleteUser(Long id) {
		Optional <User> userExists = userRepository.findById(id);
		if(userExists.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
