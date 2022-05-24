package com.exercicio.agenda.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
		
		if (pessoa.isPresent()) {
		    System.out.println("Achou");
		    return pessoa; 
		} else {
			throw new NullPointerException("ID Pessoa não encontrado.");
		}  
	} 
	
	public Pessoa SalvarPessoa(Pessoa pessoa) {
		
		Pessoa rgExiste = pessoaRepository.findByRg(pessoa.getRg());
		Pessoa cpfExiste = pessoaRepository.findByCpf(pessoa.getCpf()); 
		
		if (pessoa.getNome().length()< 3) {
			throw new UnsupportedOperationException("Nome precisa de 3 caracteres");
		}
		
		if (rgExiste!= null) {
			throw new UnsupportedOperationException("RG já cadastrado no sistema");
		}
		 
		if (cpfExiste!= null) {
			throw new UnsupportedOperationException("C.P.F já cadastrado no sistema");
		}
		
		return pessoaRepository.save(pessoa);
		
		
	}
	
	public void deletarPessoa(@Valid @PathVariable Integer id) throws Exception{
		
		 Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if (pessoa.isPresent()) {
			pessoaRepository.deleteById(id);
		} else {
			throw new NotFoundException("Id não pode ser deletado, pois não foi existe");
		}   
	}

    public Pessoa atualizarPessoa(@Valid  Integer id, Pessoa pessoa) {
    	Pessoa pessoaAtual = pessoaRepository.findById(id).get();
    	BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
    	return pessoaRepository.save(pessoaAtual);
    	
    }

}
