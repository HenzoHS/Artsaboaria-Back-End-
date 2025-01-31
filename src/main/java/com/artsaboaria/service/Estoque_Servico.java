package com.artsaboaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artsaboaria.entidade.Estoque_Ent;
import com.artsaboaria.repositorio.EstoqueRepositorio;

@Service
public class Estoque_Servico {

    @Autowired
    private EstoqueRepositorio estoqueRepository;

    // Atualizar Estoque, incluindo a quantidade de saída
    public Estoque_Ent atualizarEstoque(Long idEstoque, Estoque_Ent estoqueAtualizado) {
        // Encontrar o estoque existente
        Estoque_Ent estoqueExistente = estoqueRepository.findById(idEstoque)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        // Atualizar os campos de estoque conforme a entrada
        estoqueExistente.setNome_Produto(estoqueAtualizado.getNome_Produto());
        estoqueExistente.setUnidade_Medida(estoqueAtualizado.getUnidade_Medida());
        estoqueExistente.setQuantidade(estoqueAtualizado.getQuantidade());
        estoqueExistente.setAvaria(estoqueAtualizado.getAvaria());
        estoqueExistente.setCusto(estoqueAtualizado.getCusto());
        estoqueExistente.setEmbalagem(estoqueAtualizado.getEmbalagem());
        
        // Atualiza o estoque de saída
        estoqueExistente.setEstoq_Saida(estoqueAtualizado.getEstoq_Saida());

        // Atualizar o estoque no banco de dados
        return estoqueRepository.save(estoqueExistente);
    }
}
