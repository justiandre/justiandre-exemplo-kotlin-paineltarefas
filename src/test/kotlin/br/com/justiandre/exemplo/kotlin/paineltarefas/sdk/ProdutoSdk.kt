package br.com.justiandre.exemplo.kotlin.paineltarefas.sdk

import br.com.justiandre.exemplo.kotlin.paineltarefas.controller.ProdutoEndpoint
import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Tarefa
import br.com.justiandre.exemplo.kotlin.paineltarefas.controller.TarefaEndpoint
import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Produto
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.stereotype.Component

@Component
class ProdutoSdk {

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    fun deleteById(id: String) = testRestTemplate.delete("${ProdutoEndpoint.URI_PATH_PRODUTO}/$id")

    fun save(produto: Produto) = testRestTemplate.postForObject<Produto>(ProdutoEndpoint.URI_PATH_PRODUTO, produto, Produto::class.java)?.id

    fun findById(id: String) = testRestTemplate.getForObject("${ProdutoEndpoint.URI_PATH_PRODUTO}/$id", Produto::class.java)

}