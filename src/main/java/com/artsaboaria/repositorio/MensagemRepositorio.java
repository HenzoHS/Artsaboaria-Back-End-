package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Mensagem_Ent;

public interface MensagemRepositorio extends JpaRepository<Mensagem_Ent, Long>{

}
