package com.exercicio.agenda.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.agenda.entity.Tipo;
import com.exercicio.agenda.service.TipoService;

import antlr.collections.List;
import lombok.Getter;

@RestController
@RequestMapping("/tipos")
public class TipoController {
	
	@Autowired
	private TipoService tipoService;
	
	@GetMapping
	public  java.util.List<Tipo> listarCliente(){
		return tipoService.listarTipo();
	}
	
	@GetMapping(value="/{id}")
	public Optional<Tipo> ListarClienteId(@PathVariable("id")Integer id){
		return tipoService.ListarTipoId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tipo salvarTipo( @RequestBody Tipo tipo) {
		return tipoService.SalvarTipo(tipo);
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@Valid @PathVariable(value="id") Integer id) {
		tipoService.deletarTipo(id);
	}
	
	@PutMapping("/{id}")
	public Tipo atualizarTipo(@PathVariable Integer id,@RequestBody  Tipo tipo){
		 Tipo tipoAtual = tipoService.ListarTipoId(id).get();
		 BeanUtils.copyProperties(tipo, tipoAtual, "id");
		 return tipoService.atualizarTipo(id, tipoAtual);
		 
		}
 
}
