package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Usuario_Funcionario_Ent;

public interface UsuarioRepositorio extends JpaRepository<Usuario_Funcionario_Ent, Long> {

}
