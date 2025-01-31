package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.artsaboaria.entidade.Fornecedor_Ent;
import com.artsaboaria.repositorio.FornecedorRepositorio;


@RestController
@RequestMapping("/fornecedor")
@CrossOrigin(origins = "*")

public class FornecedorControle {

	@Autowired
	FornecedorRepositorio repositorio;
	
	@GetMapping("/listar")
	public List<Fornecedor_Ent> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping("/salvar")
	public Fornecedor_Ent salvar (@RequestBody Fornecedor_Ent entity) {
		return repositorio.save(entity);
	}
	
}
