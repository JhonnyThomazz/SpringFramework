package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Fornecedor;
import com.projetosSpring.repository.FornecedorRepository;

@Service
public class FornecedorService {

	final private FornecedorRepository fornecedorRepository;

	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	
	//Function_GetById
	public Fornecedor getSupplierById(Long Id) {
		return fornecedorRepository.findById(Id).orElse(null);
	}
	
	//Function_GetAll
	public List<Fornecedor> GetAllSupplier() {
		return fornecedorRepository.findAll();
	}
	
	//Function_Save
	public Fornecedor salvarSupplier(Fornecedor supplier) {
		return fornecedorRepository.save(supplier);
	}
	
	//Function_Update
	public Fornecedor updateSupplier(Long id, Fornecedor updateSupplier) {
		Optional <Fornecedor> SupplierExists = fornecedorRepository.findById(id);
		if(SupplierExists.isPresent()) {
			updateSupplier.setId(id);
			return fornecedorRepository.save(updateSupplier);
		}
		else {
			return null;
		}
	}
	
	//Function_Delete
	public Boolean deleteSupplier(Long id) {
		Optional<Fornecedor> SupplierExists = fornecedorRepository.findById(id);
		if(SupplierExists.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
		
	

	
}
