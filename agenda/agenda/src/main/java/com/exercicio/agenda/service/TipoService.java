package com.exercicio.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.agenda.entity.Contato;
import com.exercicio.agenda.entity.Tipo;
import com.exercicio.agenda.repository.TipoRepository;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	public List<Tipo> listarTipo() {
		return tipoRepository.findAll();
	}
	
	public Optional<Tipo> ListarTipoId(Integer id) {
		
		if (id <= 0) {
			throw new IllegalArgumentException("ID não pode ter números negativos ou ser zero.");
		}
		
		return tipoRepository.findById(id);
	}
	
	public Tipo SalvarTipo(Tipo tipo) {
		return tipoRepository.save(tipo); 
	}
	
	public void deletarTipo(Tipo tipo) {
		tipoRepository.delete(tipo);
	}
	
	public Tipo atualizarTipo(Integer id, Tipo tipo) {
		 Tipo tipoAtual = tipoRepository.findById(id).get();
		 BeanUtils.copyProperties(tipo, tipoAtual, "id");
		 return tipoRepository.save(tipoAtual);
		}

}
