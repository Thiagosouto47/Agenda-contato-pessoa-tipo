package com.exercicio.agenda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tipo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id; 
	@Column(name ="tipo_contato")
	private String nome;
	
	 @OneToMany
	 private List<Contato> contato;
	
	public Integer getId() { 
		return id; 
	}

	public void setId(Integer id) {
		this.id = id;
	} 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}
	
	

}

