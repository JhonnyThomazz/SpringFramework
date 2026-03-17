package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Cliente;
import com.projetosSpring.repository.ClienteRepository;

@Service
public class ClienteService {

	final private ClienteRepository clienteRepository;
	
	private ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	
	public List <Cliente> getAllCliente(){
		return clienteRepository.findAll();
	}
	
	
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	public Cliente updateCliente(Long id, Cliente updateC) {
		Optional <Cliente> ClienteExists = clienteRepository.findById(id);
		if(ClienteExists.isPresent()) {
			Cliente cliente = ClienteExists.get();
			BeanUtils.copyProperties(updateC, cliente, "id");
			return clienteRepository.save(cliente);
		}
		return null;
	}
	
	
	public Boolean deleteCliente(Long id) {
		Optional <Cliente> ClienteExists = clienteRepository.findById(id);
		if(ClienteExists.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
