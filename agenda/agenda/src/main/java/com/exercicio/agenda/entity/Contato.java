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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contato")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="descr_contato")
	private String descricao;  
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa; 
	
	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private Tipo tipo; 

	
	public Integer getId() { 
		return id; 
	}
	
	public String getDescricao() {
		return descricao;
		
	}
	public void setId(Integer id) { 
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	
}
