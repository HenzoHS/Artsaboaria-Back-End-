package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.artsaboaria.entidade.Vendas_Ent;
import com.artsaboaria.repositorio.VendasRepositorio;


@RestController
@RequestMapping("/vendas")
@CrossOrigin(origins = "*")

public class VendasControle {

	@Autowired
	VendasRepositorio repositorio;
	
	@GetMapping("/listar")
	public List<Vendas_Ent> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping("/salvar")
	public Vendas_Ent salvar (@RequestBody Vendas_Ent entity) {
		return repositorio.save(entity);
	}
	
}
