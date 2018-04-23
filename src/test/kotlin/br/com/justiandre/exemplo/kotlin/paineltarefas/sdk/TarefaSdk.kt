package br.com.justiandre.exemplo.kotlin.paineltarefas.sdk

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Tarefa
import br.com.justiandre.exemplo.kotlin.paineltarefas.controller.TarefaEndpoint
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.stereotype.Component

@Component
class TarefaSdk {

    @Autowired
    private lateinit var objectMapperJson: ObjectMapper

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    fun deleteById(id: String) = testRestTemplate.delete("${TarefaEndpoint.URI_PATH_TAREFA}/$id")

    fun save(tarefa: Tarefa) = testRestTemplate.postForObject<Tarefa>(TarefaEndpoint.URI_PATH_TAREFA, tarefa, Tarefa::class.java)?.id

    fun findById(id: String) = testRestTemplate.getForObject("${TarefaEndpoint.URI_PATH_TAREFA}/$id", Tarefa::class.java)

    fun findAll(): List<Tarefa> {
        val jsonTarefas = testRestTemplate.getForEntity(TarefaEndpoint.URI_PATH_TAREFA, String::class.java)?.body
        return objectMapperJson.reader().forType(object : TypeReference<List<Tarefa>>() {}).readValue<List<Tarefa>>(jsonTarefas)
    }
}