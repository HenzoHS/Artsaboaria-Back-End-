package com.artsaboaria.entidade;

import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name= "Mensagem")
public class Mensagem_Ent {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_Mensagem;
	 @Size(min =1, max = 80, message = "O email deve ter entre 1 e 80 caracteres.")
	private String email;
	 @Size(min = 0, max = 1000, message = "A mensagem deve ter entre 0 e 1000 caracteres.")
	private String mensagem;
	 private String nome_Clien;
	 private String titulo;
	 
	 public String getNome_Clien() {
		return nome_Clien;
	}
	public void setNome_Clien(String nome_Clien) {
		this.nome_Clien = nome_Clien;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Cliente_Ent getCliente_Ent() {
		return cliente_Ent;
	}
	public void setCliente_Ent(Cliente_Ent cliente_Ent) {
		this.cliente_Ent = cliente_Ent;
	}
	@ManyToOne()
	 @JoinColumn(name ="id_Cliente")
	 private Cliente_Ent cliente_Ent;
	 
	
	public Long getId_Mensagem() {
		return id_Mensagem;
	}
	public void setId_Mensagem(Long id_Mensagem) {
		this.id_Mensagem = id_Mensagem;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
