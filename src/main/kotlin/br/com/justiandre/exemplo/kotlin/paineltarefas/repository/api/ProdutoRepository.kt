package br.com.justiandre.exemplo.kotlin.paineltarefas.repository.api

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Produto
import org.springframework.data.mongodb.repository.MongoRepository

interface ProdutoRepository : MongoRepository<Produto, String> {

}