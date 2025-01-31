package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Produto_Ent;

public interface ProdutoRepositorio extends JpaRepository<Produto_Ent, Long> {

}
