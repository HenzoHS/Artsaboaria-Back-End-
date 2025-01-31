package com.artsaboaria.entidade;

import java.util.List;

import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Categoria")
public class Categoria_Ent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Categoria;
	@Size(min = 5, max = 30, message = "A categoria deve ter entre 5 e 70 caracteres.")
	private String nome_Categoria;
	private Long id_Produto;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<Produto_Ent> produtos;

	
	 public List<Produto_Ent> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto_Ent> produtos) {
		this.produtos = produtos;
	}
	public Long getId_Produto() {
		return id_Produto;
	}
	public void setId_Produto(Long id_Produto) {
		this.id_Produto = id_Produto;
	}
	public Long getId_Categoria() {
		return id_Categoria;
	}
	public void setId_Categoria(Long id_Categoria) {
		this.id_Categoria = id_Categoria;
	}
	public String getNome_Categoria() {
		return nome_Categoria;
	}
	public void setNome_Categoria(String nome_Categoria) {
		this.nome_Categoria = nome_Categoria;
	}

}
