package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Tarefa;
import com.projetosSpring.repository.TarefaRepository;

@Service
public class TarefaService {

	final private TarefaRepository tarefaRepository;
	
	private TarefaService (TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	
	public Tarefa GetTarefaById(Long id) {
		return tarefaRepository.findById(id).orElse(null);
	}
	
	public List<Tarefa> GetAllTarefas(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa SaveTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public Tarefa UpdateTarefa(Long id, Tarefa updateTarefa) {
		Optional <Tarefa> TarefaExists = tarefaRepository.findById(id);
		if(TarefaExists.isPresent()) {
			updateTarefa.setId(id);
			return tarefaRepository.save(updateTarefa);
		}
		else {
			return null;
		}
	}
	
	public Boolean deleteTarefa(Long id) {
		Optional <Tarefa> tarefaExists = tarefaRepository.findById(id);
		if(tarefaExists.isPresent()) {
			tarefaRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
