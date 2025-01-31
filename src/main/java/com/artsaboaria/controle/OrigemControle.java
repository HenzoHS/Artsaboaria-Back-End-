package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.artsaboaria.entidade.Origem_Venda_Ent;
import com.artsaboaria.repositorio.OrigemRepositorio;


@RestController
@RequestMapping("/origem")
@CrossOrigin(origins = "*")

public class OrigemControle {

	@Autowired
	OrigemRepositorio repositorio;
	
	@GetMapping("/listar")
	public List<Origem_Venda_Ent> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping("/salvar")
	public Origem_Venda_Ent salvar (@RequestBody Origem_Venda_Ent entity) {
		return repositorio.save(entity);
	}
	
}
