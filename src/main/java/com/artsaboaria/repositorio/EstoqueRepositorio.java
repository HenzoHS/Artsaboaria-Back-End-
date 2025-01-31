package com.artsaboaria.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Estoque_Ent;
import com.artsaboaria.entidade.Produto_Ent;

public interface EstoqueRepositorio extends JpaRepository<Estoque_Ent, Long>{
    Optional<Estoque_Ent> findByProduto(Produto_Ent produto);

}
