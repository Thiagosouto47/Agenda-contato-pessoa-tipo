package com.exercicio.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.agenda.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer>{

}
