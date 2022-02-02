package com.exercicio.agenda.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "pessoa") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
    private Integer id;
	@Column(name ="NOME")
	private String nome;
	@Column(name ="CPF")
	private String cpf;
	@Column(name ="rg")
	private String rg;
	@Column(name ="sexo")
	private String sexo;  
	
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contato;
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	} 
	public String getCpf() {
		return cpf;
	}
	public String getRg() {
		return rg;
	}
	public String getSexo() {
		return sexo;
		
	}
	public void setId(Integer id) { 
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	
	
	
	
	
	
	
}
