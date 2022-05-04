package com.exercicio.agenda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@Size(min = 3, max = 60, message="O nome deve ter entre 3 e 60 caracteres.")
	@NotBlank( message = "Nome não pode estar em branco")
	@Column(name ="NOME")
	private String nome;
	
	@Size(min = 14, max = 14,  message="O CPF deve seguir o padrão: 123.123.123-12.")
	@NotBlank( message = "CPF não pode estar em branco")
	@Column(name ="CPF")
	private String cpf;
	
	@Size(min = 7, max = 14, message="O nome deve ter entre 7 e 14 caracteres.")
	@NotBlank( message = "RG não pode estar em branco")
	@Column(name ="rg")
	private String rg;
	
	@Size(min = 1, max = 1,message="Coloque apenas M para masculino ou F para feminino")
	@NotBlank( message = "Sexo não pode estar em branco")
	@Column(name ="sexo")
	private String sexo;  
	
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contato;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id,
			@Size(min = 3, max = 60, message = "O nome deve ter entre 3 e 60 caracteres.") @NotBlank(message = "Nome não pode estar em branco") String nome,
			@Size(min = 14, max = 14, message = "O CPF deve seguir o padrão: 123.123.123-12.") @NotBlank(message = "CPF não pode estar em branco") String cpf,
			@Size(min = 7, max = 14, message = "O nome deve ter entre 7 e 14 caracteres.") @NotBlank(message = "RG não pode estar em branco") String rg,
			@Size(min = 1, max = 1, message = "Coloque apenas M para masculino ou F para feminino") @NotBlank(message = "Sexo não pode estar em branco") String sexo) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
	}

	public Pessoa(
			@Size(min = 3, max = 60, message = "O nome deve ter entre 3 e 60 caracteres.") @NotBlank(message = "Nome não pode estar em branco") String nome,
			@Size(min = 14, max = 14, message = "O CPF deve seguir o padrão: 123.123.123-12.") @NotBlank(message = "CPF não pode estar em branco") String cpf,
			@Size(min = 7, max = 14, message = "O nome deve ter entre 7 e 14 caracteres.") @NotBlank(message = "RG não pode estar em branco") String rg,
			@Size(min = 1, max = 1, message = "Coloque apenas M para masculino ou F para feminino") @NotBlank(message = "Sexo não pode estar em branco") String sexo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
	}

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
