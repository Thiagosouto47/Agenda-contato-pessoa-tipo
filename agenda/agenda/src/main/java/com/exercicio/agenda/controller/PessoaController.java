package com.exercicio.agenda.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listaDaAgenda() {
		
		return pessoaService.listarPessoa(); 
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Optional<Pessoa>> buscaAgendaId(@Valid @PathVariable(value="id") Integer id) throws Exception { 
		Optional<Pessoa> pessoa = this.pessoaService.listarPessoaId(id); 
		return ResponseEntity.ok(pessoa); 
 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> salvandoAgenda( @RequestBody Pessoa pessoa) { 
        Pessoa novaPessoa = pessoaService.SalvarPessoa(pessoa);
        return ResponseEntity.ok(novaPessoa);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletandoAgenda(@Valid @PathVariable(value="id") Integer id) {
		pessoaService.deletarPessoa(id);
	}
	
	@PutMapping(value="/{id}")
	public Pessoa atualizarAgenda(@Valid @PathVariable Integer id,@RequestBody Pessoa pessoa) {
		Pessoa pessoaAtual = pessoaService.listarPessoaId(id).get();
		BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
		return pessoaService.atualizarPessoa(id, pessoaAtual);
	}
	  
}
