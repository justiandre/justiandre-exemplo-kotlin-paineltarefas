package br.com.justiandre.exemplo.kotlin.paineltarefas.service

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Tarefa
import br.com.justiandre.exemplo.kotlin.paineltarefas.repository.api.TarefaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/*
*
*  O uso dessa classe poderia apenas fazer a delegação para o repositório usando o recurso
*    'Implementation by Delegation' https://kotlinlang.org/docs/reference/delegation.html do Kotlin,
*     mas com essa utilização a cobertura de código não fica de acordo porque todos métodos do
*     são expostos, porém nem todos são usados.
*
*  Exemplo dessa classe com Implementation by Delegation
*
*    @Service
*    class TarefaService(@Autowired private val tarefaRepository: TarefaRepository) :
*       TarefaRepository by tarefaRepository
*
*/

@Service
class TarefaService(@field: Autowired val tarefaRepository: TarefaRepository) {

    fun findAll() = tarefaRepository.findAll()

    fun findById(id: String) = tarefaRepository.findById(id)

    fun deleteById(id: String) = tarefaRepository.deleteById(id)

    fun save(tarefa: Tarefa) = tarefaRepository.save(tarefa)
}