package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.artsaboaria.entidade.Pedido_de_Vendas_Ent;
import com.artsaboaria.repositorio.PedidoVendaRepositorio;


@RestController
@RequestMapping("/pedidovenda")
@CrossOrigin(origins = "*")

public class PedidoVendaControle {

	@Autowired
	PedidoVendaRepositorio repositorio;
	
	@GetMapping("/listar")
	public List<Pedido_de_Vendas_Ent> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping("/salvar")
	public Pedido_de_Vendas_Ent salvar (@RequestBody Pedido_de_Vendas_Ent entity) {
		return repositorio.save(entity);
	}
	
}
