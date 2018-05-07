package br.com.justiandre.exemplo.kotlin.paineltarefas.controller

import br.com.justiandre.exemplo.kotlin.paineltarefas.service.ProdutoService
import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Produto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ProdutoEndpoint(@Autowired private val produtoService: ProdutoService) {

    companion object {
        const val PARAM_PATH_ID: String = "id"
        const val PARAM_PATH_CATEGORIA_NOME = "categoriaNome"
        const val URI_PATH_PRODUTO: String = "/produtos"
        const val URI_PATH_PRODUTO_CATEGORIA: String = "$URI_PATH_PRODUTO/categoria"
        const val URI_PATH_PRODUTO_ID: String = "$URI_PATH_PRODUTO/{$PARAM_PATH_ID}"
        const val URI_PATH_PRODUTO_CATEGORIA_NOME: String = "$URI_PATH_PRODUTO_CATEGORIA/{$PARAM_PATH_CATEGORIA_NOME}"
    }

    @GetMapping(URI_PATH_PRODUTO_ID)
    fun findById(@PathVariable(PARAM_PATH_ID) id: String) = produtoService.findById(id)

    @DeleteMapping(URI_PATH_PRODUTO_ID)
    fun deleteById(@PathVariable(PARAM_PATH_ID) id: String) = produtoService.deleteById(id)

    @PostMapping(URI_PATH_PRODUTO)
    fun save(@RequestBody produto: Produto) = produtoService.save(produto)

    @GetMapping(URI_PATH_PRODUTO_CATEGORIA_NOME)
    fun findOneByCategoriaPrincipalOrderByNomeAsc(@PathVariable(PARAM_PATH_CATEGORIA_NOME) categoriaNome: String) = produtoService.findOneByCategoriaPrincipalOrderByNomeAsc(categoriaNome)
}
 
