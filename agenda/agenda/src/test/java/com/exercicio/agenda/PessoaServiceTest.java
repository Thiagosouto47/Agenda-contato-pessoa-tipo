package com.exercicio.agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.exercicio.agenda.controller.PessoaController;
import com.exercicio.agenda.entity.Pessoa;
import com.exercicio.agenda.repository.PessoaRepository;
import com.exercicio.agenda.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class PessoaServiceTest {  
	
	 @Autowired
	 private PessoaService pessoaService;
	 
	 //@MockBean
	 @Autowired
	 private PessoaRepository pessoaRepository;
	 
    @Test
    void testeIdEncontrado() {

         Optional<Pessoa> returnedPessoa = pessoaService.listarPessoaId(4);

         Assertions.assertTrue(returnedPessoa.isPresent(), "Pessoa was not found");
    	
    }
    
    @Test
    void testeIdNaoEncontrado() throws Exception {
        
        try {
			pessoaService.listarPessoaId(null);
		} catch (NullPointerException e) {

        NullPointerException nullException = Assertions.assertThrows(NullPointerException.class, ()-> pessoaService.listarPessoaId(10));
        
    	assertEquals("ID Pessoa não encontrado.", nullException.getMessage());
    	
		}
    }
    
    @Test
    void testeIdZero() {
    	        
    	 PessoaService pessoaService = new PessoaService();

    	 IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> pessoaService.listarPessoaId(0));
    	        
    	 assertEquals("ID não pode ter números negativos ou ser zero.", exception.getMessage());
    	
    }
    
    @Test
    void testeIdNegativo() {
    	
    	 PessoaService pessoaService = new PessoaService();

    	 IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> pessoaService.listarPessoaId(-3));
    	        
    	 assertEquals("ID não pode ter números negativos ou ser zero.", exception.getMessage());
    	
    }
	
    @Test
    void testeParaEncontrarTodasPessoas() {
    	Pessoa pessoa1 = new Pessoa("jack atlas","033.163.188-09","312348-4","M");
    	Pessoa pessoa2 = new Pessoa("jack atlas","033.163.188-09","312348-4","M");
    	Pessoa pessoa3 = new Pessoa("jack atlas","033.163.188-09","312348-4","M");
    	Pessoa pessoa4 = new Pessoa("jack atlas","033.163.188-09","312348-4","M");
    	Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4);

        List<Pessoa> pessoas = pessoaService.listarPessoa(); 

        Assertions.assertEquals(4, pessoas.size() ,"deveria retornar 4 pessoas");
    }
    
    
    @Test
    void testeNomePessoaNaoPodeSerMenor3Caracteres() {
    	
    	 Pessoa pessoa = new Pessoa("th","053.163.188-09","312348-4","M"); 

    	 UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class, ()-> pessoaService.salvarPessoa(pessoa));
    	        
    	 assertEquals("Nome precisa de 3 caracteres", exception.getMessage());
    	
    }
    
    @Test
    void testeCpfNaoPodeSerIgual() {
    	 
    	 Pessoa pessoa = new Pessoa("thiago","042.588.112-11","319308-4","M"); 

    	 UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class, ()-> pessoaService.salvarPessoa(pessoa));
    	
    	 assertEquals("C.P.F já cadastrado no sistema", exception.getMessage());
    }
    
    @Test 
	 void testCadastrandoPessoaInvalido() throws Exception {
       PessoaService pessoaService = new PessoaService();
       
		assertThrows(NullPointerException.class,
				() -> pessoaService.salvarPessoa(new Pessoa("thiago","12","312348-4","M")));
	}
}
