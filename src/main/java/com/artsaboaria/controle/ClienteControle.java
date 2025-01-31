package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.artsaboaria.entidade.Cliente_Ent;
import com.artsaboaria.repositorio.ClienteRepositorio;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")

public class ClienteControle {

	@Autowired
	ClienteRepositorio repositorio;
	
	@GetMapping("/listar")
	public List<Cliente_Ent> listar(){
		return repositorio.findAll();
	}
	
	@PostMapping("/salvar")
	public Cliente_Ent salvar (@RequestBody Cliente_Ent entity) {
		return repositorio.save(entity);
	}
	
    @PostMapping("/login")
    public Cliente_Ent login(@RequestBody Cliente_Ent loginRequest) {
    	
        Cliente_Ent cliente = repositorio.findByEmailAndSenha(loginRequest.getEmail_Cliente(), loginRequest.getSenha());

        if (cliente != null && cliente.getSenha().equals(loginRequest.getSenha())) {
            // Senha correta, retorna o cliente
            return cliente;
        } else {
            // Senha incorreta ou usuário não encontrado
            throw new RuntimeException("Email ou senha inválidos");
        }
    }
	
}
