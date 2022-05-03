package com.exercicio.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercicio.agenda.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{
	

}
 