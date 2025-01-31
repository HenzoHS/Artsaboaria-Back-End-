package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.artsaboaria.entidade.Voucher_Ent;
import com.artsaboaria.repositorio.VoucherRepositorio;
import com.artsaboaria.service.VoucherServico;


@RestController
@RequestMapping("/voucher")
@CrossOrigin(origins = "*")

public class VoucherControle {

	@Autowired
	private VoucherServico voucherServico;
	
	@Autowired
	private VoucherRepositorio voucherRepositorio;
	
	@GetMapping("/listar")
	public List<Voucher_Ent> listar(){
		return voucherRepositorio.findAll();
	}
	
	@PostMapping("/aplicar")
	public ResponseEntity<Double>
	aplicarDesconto(@RequestParam String nome, @RequestParam Double vendas){
		try {
			Double valorComDesconto = voucherServico.aplicarDesconto(nome);
			return ResponseEntity.ok(valorComDesconto);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/salvar")
	public Voucher_Ent salvar (@RequestBody Voucher_Ent entity) {
		return voucherRepositorio.save(entity);
	}
	

}
