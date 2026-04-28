package com.projetosSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetosSpring.entity.Pessoa;
import com.projetosSpring.repository.PessoaRepository;

@Service
public class PessoaService {

	final private PessoaRepository pessoaRepository;
	
	private PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	public Pessoa GetPessoaById(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	public List<Pessoa> GetAllPessoa() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa SavePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa UpdatePessoa(Long id, Pessoa updatePessoa) {
		Optional <Pessoa> PessoaExists = pessoaRepository.findById(id);
		if(PessoaExists.isPresent()) {
			updatePessoa.setId(id);
			return pessoaRepository.save(updatePessoa);
		}
		else {
			return null;
		}
	}
	
	public Boolean DeletePessoa(Long id) {
		Optional <Pessoa> pessoaExists = pessoaRepository.findById(id);
		if(pessoaExists.isPresent()) {
			pessoaRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
