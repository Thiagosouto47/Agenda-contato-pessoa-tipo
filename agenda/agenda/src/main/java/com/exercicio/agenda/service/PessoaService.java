package com.exercicio.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarPessoa() {
		return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> ListarPessoaId(Integer id) {
		return pessoaRepository.findById(id);
	}
	
	public Pessoa SalvarPessoa(Pessoa pessoa) {
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
