package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.ItemExecucao;
import com.projetosSpring.repository.ItemExecRepository;

@Service
public class ItemExecService {

	final private ItemExecRepository itemExecRepository;
	
	private ItemExecService(ItemExecRepository itemExecRepository) {
		this.itemExecRepository = itemExecRepository;
	}
	
	public ItemExecucao GetItemExecucaoById(Long id) {
		return itemExecRepository.findById(id).orElse(null);
	}
	
	public List<ItemExecucao> GetAllItemExecucaos(){
		return itemExecRepository.findAll();
	}
	
	public ItemExecucao SaveItemExecucao(ItemExecucao itemExecucao) {
		return itemExecRepository.save(itemExecucao);
	}
	
	public ItemExecucao UpdateItemExecucao(Long id, ItemExecucao updateItemExecucao) {
		Optional <ItemExecucao> ItemExecucaoExists = itemExecRepository.findById(id);
		if(ItemExecucaoExists.isPresent()) {
			updateItemExecucao.setId(id);
			return itemExecRepository.save(updateItemExecucao);
		}
		else {
			return null;
		}
	}
	
	public Boolean deleteItemExecucao(Long id) {
		Optional <ItemExecucao> itemExecRepositoryExists = itemExecRepository.findById(id);
		if(itemExecRepositoryExists.isPresent()) {
			itemExecRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
