package com.exercicio.agenda.controller;

import java.util.List;
import java.util.Optional;

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

import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.entity.Contato;
import com.exercicio.agenda.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public List<Contato> listaDaContato() {
		return contatoService.listarContato();
	}
	
	@GetMapping("/{id}")
	public Optional<Contato> buscaContatoId(@PathVariable(value="id") Integer id) {
		return contatoService.ListarContatoId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato salvandoContato(@RequestBody Contato contato) {
		return contatoService.SalvarContato(contato);
	}
	
	@DeleteMapping
	public void deletandoContato(@RequestBody Contato contato) {
		contatoService.deletarContato(contato);
	}
 
	@PutMapping("/{id}")
	public Contato atualizandoContato(@PathVariable Integer id,@RequestBody Contato contato) {
		Contato contatoAtual = contatoService.ListarContatoId(id).get();
		BeanUtils.copyProperties(contato, contatoAtual, "id");
		return contatoService.atualizarContato(id, contatoAtual);
	}  

} 
