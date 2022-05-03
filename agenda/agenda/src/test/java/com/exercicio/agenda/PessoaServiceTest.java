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
	
	 @MockBean
	 private PessoaRepository pessoaRepository;
	 
    @Test
    void testeIdEncontrado() {
    	
    	Pessoa pessoa = new Pessoa(1,"thiago","053.163.188-09","312348-4","M");
         doReturn(Optional.of(pessoa)).when(pessoaRepository).findById(1); 

         // Execute the service call
         Optional<Pessoa> returnedPessoa = pessoaService.listarPessoaId(1);

         // Assert the response
         Assertions.assertTrue(returnedPessoa.isPresent(), "Pessoa was not found");
         Assertions.assertSame(returnedPessoa.get(), pessoa, "The pessoa returned was not the same as the mock");
    	
    }
    
    @Test
    void testeIdNaoEncontrado() {
        doReturn(Optional.empty()).when(pessoaRepository).findById(1);

        // Execute the service call
        Optional<Pessoa> returnedPessoa = pessoaService.listarPessoaId(1);

        // Assert the response
        Assertions.assertFalse(returnedPessoa.isPresent(), "Pessoa should not be found");
    }
	
    @Test
    void testeParaEncontrarTodasPessoas() {
        // Setup our mock repository
    	Pessoa pessoa1 = new Pessoa(1,"jack atlas","033.163.188-90","312333-7","M");
    	Pessoa pessoa2 = new Pessoa(2,"Lucas Silavana","144.188.188-09","016340-0","M");
    	Pessoa pessoa3 = new Pessoa(3,"Eliane Callegi","006.609.188-15","652379-1","F");
    	Pessoa pessoa4 = new Pessoa(4,"Marcos Racing","056.123.155-19","282349-1","M");
    	doReturn(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4)).when(pessoaRepository).findAll();

       

        // Execute the service call
        List<Pessoa> pessoas = pessoaService.listarPessoa(); 

        // Assert the response
        Assertions.assertEquals(4, pessoas.size() ,"deveria retornar 4 pessoas");
    }
    
    @Test
    void testeParaSalvarPessoa() throws Exception {
        // Setup our mock repository
    	Pessoa pessoa = new Pessoa(2,"jack atlas","033.163.188-09","312348-4","M");
        doReturn(pessoa).when(pessoaRepository).save(any());

        // Execute the service call
        Pessoa returnedPessoa = pessoaService.SalvarPessoa(pessoa);

        // Assert the response
        Assertions.assertNotNull(returnedPessoa, "The saved widget should not be null");
        Assertions.assertEquals(2, returnedPessoa.getId(), "The version should be incremented");
    }

}
