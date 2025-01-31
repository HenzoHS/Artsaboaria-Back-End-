package com.artsaboaria.entidade;

import javax.validation.constraints.Size;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Estoque")
public class Estoque_Ent {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_Estoque;
	 @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres.")
	private String nome_Produto;
	 @Size(min = 5, max = 10, message = "A unidade de medida deve ter entre 5 e 10 caracteres.")
	private String unidade_Medida;
	private int quantidade;
	 @Size(min = 5, max = 70, message = "A avaria deve ter entre 5 e 70 caracteres.")
	private String avaria;
	private Float custo;
	private String embalagem;
	private int estoq_Saida;
	private int estoq_Entra;
	
	public int getEstoq_Entra() {
		return this.estoq_Entra;
	}
	public void setEstoq_Entra(int estoq_Entra) {
		this.estoq_Entra = estoq_Entra;
	}
	public int getEstoq_Saida() {
		return estoq_Saida;
	}
	public void setEstoq_Saida(int estoq_Saida) {
		this.estoq_Saida = estoq_Saida;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "id_Categoria")
	private Categoria_Ent categoria;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private Produto_Ent produto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "id_Fornecedor")
	private Fornecedor_Ent fornecedor;
	
	
	public Categoria_Ent getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria_Ent categoria) {
		this.categoria = categoria;
	}
	public Produto_Ent getProduto() {
		return produto;
	}
	public void setProduto(Produto_Ent produto) {
		this.produto = produto;
	}
	public Fornecedor_Ent getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor_Ent fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Long getId_Estoque() {
		return id_Estoque;
	}
	public void setId_Estoque(Long id_Estoque) {
		this.id_Estoque = id_Estoque;
	}
	public String getNome_Produto() {
		return nome_Produto;
	}
	public void setNome_Produto(String nome_Produto) {
		this.nome_Produto = nome_Produto;
	}
	public String getUnidade_Medida() {
		return unidade_Medida;
	}
	public void setUnidade_Medida(String unidade_Medida) {
		this.unidade_Medida = unidade_Medida;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getAvaria() {
		return avaria;
	}
	public void setAvaria(String avaria) {
		this.avaria = avaria;
	}
	public Float getCusto() {
		return custo;
	}
	public void setCusto(Float custo) {
		this.custo = custo;
	}

	public String getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}



	
	
	
}
