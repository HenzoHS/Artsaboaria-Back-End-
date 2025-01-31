package com.artsaboaria.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.artsaboaria.entidade.Estoque_Ent;
import com.artsaboaria.entidade.Produto_Ent;
import com.artsaboaria.repositorio.EstoqueRepositorio;
import com.artsaboaria.repositorio.ProdutoRepositorio;
import com.artsaboaria.service.Estoque_Servico;


@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins = "*")

public class EstoqueControle {

	@Autowired
	EstoqueRepositorio repositorio;
	
	@Autowired
	Estoque_Servico estoque_Servico;
	
	@GetMapping("/listar")
	public List<Estoque_Ent> listar(){
		return repositorio.findAll();
	}
	@Autowired
    private EstoqueRepositorio estoqueRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;
	@PostMapping("/salvar")
	public Estoque_Ent salvar (@RequestBody Estoque_Ent entity) {
		return repositorio.save(entity);
	}
    @Autowired
    private Estoque_Servico estoqueService;

    @PutMapping("/atualizar/{id_Estoque}")
    public ResponseEntity<Estoque_Ent> atualizarEstoque(@PathVariable Long id_Estoque, @RequestBody Estoque_Ent estoqueAtualizado) {
        if (!repositorio.existsById(id_Estoque)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Retorna 404 se o estoque não existir
        }
        
        estoqueAtualizado.setId_Estoque(id_Estoque);  // Atualiza o ID do estoque
        Estoque_Ent estoqueSalvo = repositorio.save(estoqueAtualizado);
        
        return ResponseEntity.ok(estoqueSalvo);  }// Retorna o estoque atualizado
        


            

            // Endpoint para adicionar entrada no estoque
            @PostMapping("/entrada/{idProduto}")
            public ResponseEntity<Estoque_Ent> adicionarEntrada(@PathVariable Long idProduto, @RequestBody Estoque_Ent movimentacao) {
                Produto_Ent produto = produtoRepositorio.findById(idProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                Estoque_Ent estoque = estoqueRepositorio.findByProduto(produto)
                        .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

                // Atualizando a quantidade de estoque com a entrada
                estoque.setEstoq_Entra( estoque.getEstoq_Entra() + movimentacao.getEstoq_Entra());
                
                estoque.setQuantidade(estoque.getEstoq_Entra() - estoque.getEstoq_Saida() ); // Calcula o estoque total após a entrada

                estoqueRepositorio.save(estoque);

                return ResponseEntity.ok(estoque);
            }

            // Endpoint para remover saída no estoque
            @PostMapping("/saida/{idProduto}")
            public ResponseEntity<Estoque_Ent> removerSaida(@PathVariable Long idProduto, @RequestBody Estoque_Ent movimentacao) {
                Produto_Ent produto = produtoRepositorio.findById(idProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                Estoque_Ent estoque = estoqueRepositorio.findByProduto(produto)
                        .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

                // Verificando se há estoque suficiente para a saída
                if (estoque.getQuantidade() < movimentacao.getEstoq_Saida()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Estoque insuficiente
                }

                // Atualizando a quantidade de estoque com a saída
                estoque.setEstoq_Saida(estoque.getEstoq_Saida() + movimentacao.getEstoq_Saida());
                estoque.setQuantidade(estoque.getEstoq_Entra() - estoque.getEstoq_Saida()); // Calcula o estoque total após a saída

                estoqueRepositorio.save(estoque);

                return ResponseEntity.ok(estoque);
            }

            // Endpoint para consultar o estoque de um produto
            @GetMapping("/{idProduto}")
            public ResponseEntity<Estoque_Ent> consultarEstoque(@PathVariable Long idProduto) {
                Produto_Ent produto = produtoRepositorio.findById(idProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                Estoque_Ent estoque = estoqueRepositorio.findByProduto(produto)
                        .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

                return ResponseEntity.ok(estoque);
            }
    

    
}
