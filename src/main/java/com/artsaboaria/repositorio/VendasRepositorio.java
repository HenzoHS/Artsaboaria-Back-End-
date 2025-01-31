package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Vendas_Ent;

public interface VendasRepositorio extends JpaRepository<Vendas_Ent, Long> {

}
