package com.artsaboaria.entidade;



import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Usuario Funcionario")
public class Usuario_Funcionario_Ent {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_Usuario;
	 @Size(min = 5, max = 150, message = "O nome deve ter entre 5 e 150 caracteres.")
	private String nome_Usuario;
	 @Size(min = 11, max = 11, message = "O telefone deve ter 11 caracteres.")
	private String telefone;
	 @Size(min = 5, max = 50, message = "O senha deve ter entre 5 e 50 caracteres.")
	private String senha;
	 private Boolean status_Vendedor;
	 
	
	public Boolean getStatus_Vendedor() {
		return status_Vendedor;
	}
	public void setStatus_Vendedor(Boolean status_Vendedor) {
		this.status_Vendedor = status_Vendedor;
	}
	public Long getId_usuario() {
		return id_Usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_Usuario = id_usuario;
	}
	public String getNome_Usuario() {
		return nome_Usuario;
	}
	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
