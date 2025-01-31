package com.artsaboaria.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsaboaria.entidade.Voucher_Ent;
import com.artsaboaria.repositorio.VoucherRepositorio;



@Service
public class VoucherServico {
	private Double vendas = 50.0;
	@Autowired
	private VoucherRepositorio VouhceRepositorio;
	
	public Double aplicarDesconto(String nome) {
		
		Voucher_Ent voucher = VouhceRepositorio.findByNome(nome).orElseThrow(() -> new
				IllegalArgumentException("Voucher não encontrado"));
		
		Double desconto = voucher.getDesconto();
		return (vendas - desconto);

	
}}
