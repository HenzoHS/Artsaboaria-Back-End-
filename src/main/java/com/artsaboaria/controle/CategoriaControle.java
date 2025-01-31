package com.artsaboaria.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artsaboaria.entidade.Categoria_Ent;
import com.artsaboaria.entidade.Estoque_Ent;
import com.artsaboaria.entidade.Produto_Ent;
import com.artsaboaria.repositorio.CategoriaRepositorio;
import com.artsaboaria.repositorio.EstoqueRepositorio;
import com.artsaboaria.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
@Controller
public class CategoriaControle {

	@Autowired
	CategoriaRepositorio repositorio;
	
	
	
	@GetMapping("/listar")
	public List<Categoria_Ent> listar(
	          @RequestParam(defaultValue = "1") int page, 
	          @RequestParam(defaultValue = "10") int size,
	          @RequestParam(defaultValue = "nome") String nome
	){
	    List<Categoria_Ent> l = repositorio.findAll();
	    
	  
	    if (page <= 0) {
	        page = 1;
	    }

	   
	    int start = (page - 1) * size;
	    int end = Math.min(start + size, l.size()); 

	    
	    if (start >= l.size()) {
	        return new ArrayList<>();
	    }

	    List<Categoria_Ent> reto = l.subList(start, end);
	    return reto;
	}
	
	@PostMapping("/salvar")
	public Categoria_Ent salvar (@RequestBody Categoria_Ent entity) {
		return repositorio.save(entity);
	}
	@DeleteMapping("/excluir/{id}")
		public ResponseEntity<String> excluir(@PathVariable Long id){
		if (!repositorio.existsById(id)) {
			return ResponseEntity.status(404).body("Cliente não identificado!");
		}
		repositorio.deleteById(id);
		return ResponseEntity.status(200).body("Excluído com sucesse!");
	}

}
