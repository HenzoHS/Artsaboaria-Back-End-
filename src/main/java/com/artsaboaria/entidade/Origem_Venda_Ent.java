package com.artsaboaria.entidade;



import javax.validation.constraints.Size;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Origem da Venda")

public class Origem_Venda_Ent {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_Origem;
	@Size(min = 5, max = 20, message = "O nome da origem deve ter entre 5 e 20 caracteres.")
	 private String nome_Origem;
	 public Long getId() {
		return id_Origem;
	}
	public void setId(Long id) {
		this.id_Origem = id;
	}
	public Long getId_Origem() {
		return id_Origem;
	}
	public void setId_Origem(Long id_Origem) {
		this.id_Origem = id_Origem;
	}
	public String getNome_Origem() {
		return nome_Origem;
	}
	public void setNome_Origem(String nome_Origem) {
		this.nome_Origem = nome_Origem;
	}


}
