package com.exercicio.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.agenda.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
