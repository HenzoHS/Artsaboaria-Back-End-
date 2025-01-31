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
@Table (name = "Fornecedor")
public class Fornecedor_Ent {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_Fornecedor;
	 @Size(min = 5, max = 70, message = "O nome deve ter entre 5 e 70 caracteres.")
	private String nome_Fornecedor;
	 @Size(min = 14, max = 14, message = "O cnpj deve ter 14 caracteres.")
	private String cnpj_Fornecedor;
	 @Size(min = 5, max = 85, message = "O endereço deve ter entre 5 e 85 caracteres.")
	private String endereco_Fornecedor;
	 @Size(min = 5, max = 150, message = "O telefone deve ter entre 9 e 11 caracteres.")
	private String telefone_Fornecedor;
	 @Size(min = 5, max = 80, message = "O email deve ter entre 5 e 80 caracteres.")
	private String email_Fornecedor;
	 
	 @ManyToOne()
	 @JoinColumn(name = "id_Categoria")
	 private Categoria_Ent Cliente_Ent;
	
	public Long getId_fornecedor() {
		return id_Fornecedor;
	}
	public void setId_fornecedor(Long id_Fornecedor) {
		this.id_Fornecedor = id_Fornecedor;
	}
	public String getNome_Fornecedor() {
		return nome_Fornecedor;
	}
	public void setNome_Fornecedor(String nome_Fornecedor) {
		this.nome_Fornecedor = nome_Fornecedor;
	}
	public String getCnpj_Fornecedor() {
		return cnpj_Fornecedor;
	}
	public void setCnpj_Fornecedor(String cnpj_Fornecedor) {
		this.cnpj_Fornecedor = cnpj_Fornecedor;
	}
	public String getEndereco_Fornecedor() {
		return endereco_Fornecedor;
	}
	public void setEndereco_Fornecedor(String endereco_Fornecedor) {
		this.endereco_Fornecedor = endereco_Fornecedor;
	}
	public String getTelefone_Fornecedor() {
		return telefone_Fornecedor;
	}
	public void setTelefone_Fornecedor(String telefone_Fornecedor) {
		this.telefone_Fornecedor = telefone_Fornecedor;
	}
	public String getEmail_Fornecedor() {
		return email_Fornecedor;
	}
	public void setEmail_Fornecedor(String email_Fornecedor) {
		this.email_Fornecedor = email_Fornecedor;
	}


}
