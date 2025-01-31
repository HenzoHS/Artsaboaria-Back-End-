package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Categoria_Ent;

public interface CategoriaRepositorio extends JpaRepository<Categoria_Ent, Long>{

}
