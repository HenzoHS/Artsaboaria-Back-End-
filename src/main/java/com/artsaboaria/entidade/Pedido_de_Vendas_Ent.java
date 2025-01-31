package com.artsaboaria.entidade;

import java.time.LocalDate;

import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Carrinho")


public class Pedido_de_Vendas_Ent {

	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Long id_Carrinho;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_Pedido;
	 @Size(min = 5, max = 15, message = "O Status do pedido deve ter entre 5 e 15 caracteres.")
	private String status_Pedido;
	 @Size(min = 5, max = 70, message = "O destino deve ter entre 5 e 70 caracteres.")
	private String destino;
	private int qtd_Produtos_Pedidos;
	private Float valor_Total;
	private Float impostos;
	private Float frete;
	
	@ManyToOne()
	@JoinColumn(name = "id_Cliente")
	private Cliente_Ent Cliente_Ent;
	@ManyToOne()
	@JoinColumn(name= "id_Usuario")
	private Usuario_Funcionario_Ent Usuario_Funcionario_Ent;
	@ManyToOne()
	@JoinColumn(name = "id_Produto")
	private Produto_Ent Produto_Ent;
	@ManyToOne()
	@JoinColumn(name= "id_Voucher")
	private Voucher_Ent Vocher_Ent;
	
	
	public Long getId_carrinho() {
		return id_Carrinho;
	}
	public void setId_carrinho(Long id_carrinho) {
		this.id_Carrinho = id_carrinho;
	}
	public LocalDate getData_Pedido() {
		return data_Pedido;
	}
	public void setData_Pedido(LocalDate data_Pedido) {
		this.data_Pedido = data_Pedido;
	}
	public String getStatus_Pedido() {
		return status_Pedido;
	}
	public void setStatus_Pedido(String status_Pedido) {
		this.status_Pedido = status_Pedido;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getQtd_Produtos_Pedidos() {
		return qtd_Produtos_Pedidos;
	}
	public void setQtd_Produtos_Pedidos(int qtd_Produtos_Pedidos) {
		this.qtd_Produtos_Pedidos = qtd_Produtos_Pedidos;
	}
	public Float getValor_Total() {
		return valor_Total;
	}
	public void setValor_Total(Float valor_Total) {
		this.valor_Total = valor_Total;
	}
	public Float getImpostos() {
		return impostos;
	}
	public void setImpostos(Float impostos) {
		this.impostos = impostos;
	}
	public Float getFrete() {
		return frete;
	}
	public void setFrete(Float frete) {
		this.frete = frete;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	private Float subtotal;
	
}
