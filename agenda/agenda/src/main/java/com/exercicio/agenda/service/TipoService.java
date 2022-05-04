package com.exercicio.agenda.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.exercicio.agenda.entity.Contato;
import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.entity.Tipo;
import com.exercicio.agenda.repository.TipoRepository;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	public List<Tipo> listarTipo() {
		return tipoRepository.findAll();
	}
	
	public Optional<Tipo> ListarTipoId(@Valid Integer id) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("ID não pode ter números negativos ou ser zero.");
		}
		
       Optional<Tipo> tipo = tipoRepository.findById(id);
		
		if (tipo.isPresent()) {
		    System.out.println("Achou");
		    return tipo;
		} else {
			throw new NullPointerException("ID tipo não encontrado.");
		
		} 
	}
	
	public Tipo SalvarTipo(@Valid Tipo tipo) {
		return tipoRepository.save(tipo); 
	}
	
	public void deletarTipo(@Valid @PathVariable Integer id) {
		tipoRepository.deleteById(id);
	} 
	
	public Tipo atualizarTipo(@Valid  Integer id, Tipo tipo) {
		 Tipo tipoAtual = tipoRepository.findById(id).get();
		 BeanUtils.copyProperties(tipo, tipoAtual, "id");
		 return tipoRepository.save(tipoAtual);
		}

}
