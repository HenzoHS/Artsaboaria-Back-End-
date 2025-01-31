package com.artsaboaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artsaboaria.entidade.Pedido_de_Vendas_Ent;

public interface PedidoVendaRepositorio extends JpaRepository<Pedido_de_Vendas_Ent, Long> {

}
