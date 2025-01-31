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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name= "Vendas")

public class Vendas_Ent {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Venda;
	private String forma_de_Pagamento;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_Pedido;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_Compra;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_cancelamento;
	 @Size(min = 5, max = 15, message = "O Status do Pedido deve ter entre 5 e 15 caracteres.")
	private String status_Pedido;
	 @Size(min = 5, max = 40, message = "O Destino do Pedido deve ter entre 5 e 40 caracteres.")
	private String destino_Cidade;
	private Integer qtd_Comprada;
	private Float valor_total;
	private Float valor_imposto;
	private Float valor_Frete;
	private Float subtotal;
	
	@ManyToOne()
	@JoinColumn(name="id_Cliente")
	private Cliente_Ent Cliente_Ent;
	
	@ManyToOne()
	@JoinColumn(name= "id_Produto")
	private Produto_Ent Produto_Ent;
	
	@ManyToOne()
	@JoinColumn(name = "id_Usuario")
	private Usuario_Funcionario_Ent usuario_Funcionario_Ent;
	
	@ManyToOne()
	@JoinColumn(name = "id_Voucher")
	private Voucher_Ent Voucher_Ent;
	
	@OneToOne
	private Voucher_Ent vocuher;
	
	public String getForma_de_Pagamento() {
		return forma_de_Pagamento;
		
	}
	public void setForma_de_Pagamento(String forma_de_Pagamento) {
		this.forma_de_Pagamento = forma_de_Pagamento;
	}

	 @Size(min = 5, max = 12, message = "O Status da venda deve ter entre 5 e 40 caracteres.")
	private String status_Venda;
	public Long getVenda() {
		return id_Venda;
	}
	public void setVenda(Long venda) {
		this.id_Venda = venda;
	}
	public LocalDate getData_Pedido() {
		return data_Pedido;
	}
	public void setData_Pedido(LocalDate data_Pedido) {
		this.data_Pedido = data_Pedido;
	}
	public LocalDate getData_Compra() {
		return data_Compra;
	}
	public void setData_Compra(LocalDate data_Compra) {
		this.data_Compra = data_Compra;
	}
	public LocalDate getData_cancelamento() {
		return data_cancelamento;
	}
	public void setData_cancelamento(LocalDate data_cancelamento) {
		this.data_cancelamento = data_cancelamento;
	}
	public String getStatus_Pedido() {
		return status_Pedido;
	}
	public void setStatus_Pedido(String status_Pedido) {
		this.status_Pedido = status_Pedido;
	}
	public String getDestino_Cidade() {
		return destino_Cidade;
	}
	public void setDestino_Cidade(String destino_Cidade) {
		this.destino_Cidade = destino_Cidade;
	}
	public int getQtd_Comprada() {
		return qtd_Comprada;
	}
	public void setQtd_Comprada(int qtd_Comprada) {
		this.qtd_Comprada = qtd_Comprada;
	}
	public Float getValor_total() {
		return valor_total;
	}
	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}
	public Float getValor_imposto() {
		return valor_imposto;
	}
	public void setValor_imposto(Float valor_imposto) {
		this.valor_imposto = valor_imposto;
	}
	public Float getValor_Frete() {
		return valor_Frete;
	}
	public void setValor_Frete(Float valor_Frete) {
		this.valor_Frete = valor_Frete;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public String getStatus_Venda() {
		return status_Venda;
	}
	public void setStatus_Venda(String status_Venda) {
		this.status_Venda = status_Venda;
	}
	
	
}
