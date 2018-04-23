package br.com.justiandre.exemplo.kotlin.paineltarefas.repository.api

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Tarefa
import org.springframework.data.mongodb.repository.MongoRepository

interface TarefaRepository : MongoRepository<Tarefa, String>