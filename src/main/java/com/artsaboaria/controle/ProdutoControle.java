package com.artsaboaria.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artsaboaria.entidade.Categoria_Ent;
import com.artsaboaria.entidade.Estoque_Ent;
import com.artsaboaria.entidade.Produto_Ent;
import com.artsaboaria.repositorio.CategoriaRepositorio;
import com.artsaboaria.repositorio.EstoqueRepositorio;
import com.artsaboaria.repositorio.ProdutoRepositorio;


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*")

public class ProdutoControle {

	@Autowired
	ProdutoRepositorio repositorio;
	
	@Autowired
	EstoqueRepositorio estoqueRepositorio;
	
	   @Autowired
	    CategoriaRepositorio categoriaRepositorio; 
	
	@GetMapping("/listar")
	public List<Produto_Ent> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping("/salvar")
	public Produto_Ent salvar (@RequestBody Produto_Ent entity) {
		
		   Estoque_Ent estoque = new Estoque_Ent();
		    Categoria_Ent categoria = new Categoria_Ent();
		            

		    Produto_Ent produtoSalvo = repositorio.save(entity);
		    
		  
		    estoque = produtoSalvo.getEstoque();
		    categoria = produtoSalvo.getCategoria();
		    
		    List<Produto_Ent> listaDeProdutos =  new ArrayList<>();
		    listaDeProdutos.add(produtoSalvo);
		    
		   
		    categoria.setProdutos(listaDeProdutos);
		    
		    
		    estoque.setProduto(produtoSalvo);
		    
		
		    estoqueRepositorio.save(estoque);
		    
		
		    categoriaRepositorio.save(categoria);
		    
	
		    return produtoSalvo;
	}
	
}
