package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artsaboaria.entidade.Cliente_Ent;

public interface ClienteRepositorio extends JpaRepository<Cliente_Ent, Long>{

    @Query("SELECT c FROM Cliente_Ent c WHERE c.email_Cliente = :email AND c.senha = :senha")
    Cliente_Ent findByEmailAndSenha(String email, String senha);
}
