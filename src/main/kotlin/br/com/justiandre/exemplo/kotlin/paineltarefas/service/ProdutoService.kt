package br.com.justiandre.exemplo.kotlin.paineltarefas.service

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Produto
import br.com.justiandre.exemplo.kotlin.paineltarefas.repository.api.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoService(@field: Autowired val produtoRepository: ProdutoRepository) {

    fun findById(id: String) = produtoRepository.findById(id)

    fun deleteById(id: String) = produtoRepository.deleteById(id)

    fun save(produto: Produto) = produtoRepository.save(produto)

    fun findOneByCategoriaPrincipalOrderByNomeAsc(nome: String) = produtoRepository.findByCategoriaPrincipalOrderByNomeAsc(nome)?.firstOrNull()
}