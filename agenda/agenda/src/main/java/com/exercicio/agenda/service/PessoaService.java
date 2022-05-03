package com.exercicio.agenda.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.repository.PessoaRepository;

import lombok.NonNull;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarPessoa() {
		return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> listarPessoaId(@Valid @PathVariable Integer id) {
		
		
		if (id <= 0) {
			throw new IllegalArgumentException("ID não pode ter números negativos ou ser zero.");
		}
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if (pessoa == null) {
			throw new NullPointerException("ID não encontrado.");
		
		}
		
		return pessoa; 
	} 
	
	public Pessoa SalvarPessoa(Pessoa pessoa) throws Exception  {
		return pessoaRepository.save(pessoa);
	}
	
	public void deletarPessoa(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}

    public Pessoa atualizarPessoa(Integer id, Pessoa pessoa) {
    	Pessoa pessoaAtual = pessoaRepository.findById(id).get();
    	BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
    	return pessoaRepository.save(pessoaAtual);
    	
    }

}
