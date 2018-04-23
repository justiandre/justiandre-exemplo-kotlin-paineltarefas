package br.com.justiandre.exemplo.kotlin.paineltarefas.controller

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Tarefa
import br.com.justiandre.exemplo.kotlin.paineltarefas.service.TarefaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TarefaEndpoint(@Autowired private val tarefaService: TarefaService) {

    companion object {
        const val PARAM_PATH_ID: String = "id"
        const val URI_PATH_TAREFA: String = "/tarefas"
        const val URI_PATH_TAREFA_ID: String = "$URI_PATH_TAREFA/{$PARAM_PATH_ID}"
    }

    @GetMapping(URI_PATH_TAREFA)
    fun findAll() = tarefaService.findAll()

    @GetMapping(URI_PATH_TAREFA_ID)
    fun findById(@PathVariable(PARAM_PATH_ID) id: String) = tarefaService.findById(id)

    @DeleteMapping(URI_PATH_TAREFA_ID)
    fun deleteById(@PathVariable(PARAM_PATH_ID) id: String) = tarefaService.deleteById(id)

    @PostMapping(URI_PATH_TAREFA)
    fun save(@RequestBody tarefa: Tarefa) = tarefaService.save(tarefa)
}
 
