package com.exercicio.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.entity.Contato;
import com.exercicio.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<Contato> listarContato() {
		return contatoRepository.findAll();
	}
	

	public Optional<Contato> ListarContatoId(Integer id) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("ID não pode ter números negativos ou ser zero.");
		}
		
		return contatoRepository.findById(id);
	}
	
	public Contato SalvarContato(Contato contato) {
		return contatoRepository.save(contato);
	}
	
	public void deletarContato(Contato contato) {
		contatoRepository.delete(contato);
	}
	
	public Contato atualizarContato(Integer id, Contato contato) {
		 Contato contatoAtual = contatoRepository.findById(id).get();
		 BeanUtils.copyProperties(contato, contatoAtual, "id");
		 return contatoRepository.save(contatoAtual);
		}

}
