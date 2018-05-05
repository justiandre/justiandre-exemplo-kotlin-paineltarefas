package br.com.justiandre.exemplo.kotlin.paineltarefas.it

import br.com.justiandre.exemplo.kotlin.paineltarefas.base.ApplicationBaseIT
import br.com.justiandre.exemplo.kotlin.paineltarefas.base.GeradorDados
import br.com.justiandre.exemplo.kotlin.paineltarefas.sdk.ProdutoSdk
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class ProdutoIT : ApplicationBaseIT() {

    @Autowired
    private lateinit var produtoSdk: ProdutoSdk

    @Autowired
    private lateinit var geradorDados: GeradorDados

    @Test
    fun `Consultar produto por id sem esperar resultado`() {
        val produtoConsulta = produtoSdk.findById(UUID.randomUUID().toString())
        Assert.assertNull("Não deveria retornar produto", produtoConsulta)
    }


}
 