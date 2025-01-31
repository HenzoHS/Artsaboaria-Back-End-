package com.artsaboaria.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import javax.validation.constraints.Size;

@Entity
@Table (name =  "Cliente")

public class Cliente_Ent {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_Cliente;
    @Size(max = 70, message = "O nome deve ter entre 5 e 70 caracteres.")
	private String nome_Cliente;
    @Size(max = 100, message ="O email deve ter entre 1 e 100 caracteres.")
	private String email_Cliente;
    @Size(max = 14, message ="O CPF deve ter 11 caracteres. O CNPJ deve ter 14 caracteres ")
	private String cpf_Cnpj_Cliente;
    @Size(max = 11, message ="O Telefone ou Telefone fixo deve ter entre 8 e 11 caracteres.")
	private String telefone_Contato;
    @Size(max = 8, message ="O CEP deve ter 8 caracteres.")
	private String cep_Cliente;
    @Size(max = 80, message ="O endereço deve ter entre 1 e 80 caracteres.")
	private String endereco;
    @Size(max = 80, message ="O cidade deve ter entre 1 e 80 caracteres.")
	private String cidade;
    @Size(max = 80, message ="A senha deve ter entre 1 e 80 caracteres.")
	private String senha;
    
    @OneToMany(mappedBy = "Cliente_Ent")
    private List<Vendas_Ent> listaDeVendas;
    
    
	public long getId_cliente() {
		return id_Cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_Cliente = id_cliente;
	}
	public String getNome_Cliente() {
		return nome_Cliente;
	}
	public void setNome_Cliente(String nome_Cliente) {
		this.nome_Cliente = nome_Cliente;
	}
	public String getEmail_Cliente() {
		return email_Cliente;
	}
	public void setEmail_Cliente(String email_Cliente) {
		this.email_Cliente = email_Cliente;
	}
	public String getCpf_Cnpj_Cliente() {
		return cpf_Cnpj_Cliente;
	}
	public void setCpf_Cnpj_Cliente(String cpf_Cnpj_Cliente) {
		this.cpf_Cnpj_Cliente = cpf_Cnpj_Cliente;
	}
	public String getTelefone_Contato() {
		return telefone_Contato;
	}
	public void setTelefone_Contato(String telefone_Contato) {
		this.telefone_Contato = telefone_Contato;
	}
	public String getCep_Cliente() {
		return cep_Cliente;
	}
	public void setCep_Cliente(String cep_Cliente) {
		this.cep_Cliente = cep_Cliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
