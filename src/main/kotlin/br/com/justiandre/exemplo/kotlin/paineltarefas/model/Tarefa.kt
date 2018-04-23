package br.com.justiandre.exemplo.kotlin.paineltarefas.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tarefas")
data class Tarefa(
        @Id var id: String? = null,
        var dtrecebimento: String? = null,
        var cdusuariocriacao: String? = null,
        var nmusuariocriacao: String? = null,
        var status: String? = null,
        var dtprazofatal: String? = null,
        var demanda: Demanda? = null,
        var processo: Processo? = null,
        var atividades: List<Atividade>? = null,
        var partes: List<Parte>? = null
)

data class Parte(
        var nuseqparte: Double? = null,
        var cdtipoparte: Double? = null,
        var cdpessoa: Double? = null,
        var nmpessoa: String? = null,
        var flprincipal: String? = null,
        var tpparte: Double? = null
)

data class Processo(
        var cdprocesso: String? = null,
        var nujudicial: String? = null,
        var fllitispendencia: String? = null,
        var cdassuntoconsulta: Double? = null,
        var deassuntoconsulta: String? = null,
        var cdclasse: Double? = null,
        var declasse: String? = null,
        var cdarea: Double? = null,
        var dearea: String? = null,
        var flpolopj: String? = null,
        var cdparteativa: Double? = null,
        var nmparteativa: String? = null,
        var cdpartepassiva: Double? = null,
        var nmpartepassiva: String? = null,
        var flgrandedevedor: String? = null
)

data class Demanda(
        var nuseqprocessomv: Double? = null,
        var detipodemanda: String? = null,
        var dedemanda: String? = null,
        var cdtipomvprocesso: Double? = null
)

data class Atividade(
        var cdpendencia: Double? = null,
        var dtcriacao: String? = null,
        var dtprazo: String? = null,
        var cdusuario: String? = null,
        var nmusuario: String? = null,
        var cdusuariocriacaoatividade: String? = null,
        var nmusuariocriacaoatividade: String? = null,
        var cdcategoria: Double? = null,
        var decategoria: String? = null,
        var cdcategoriapend: Double? = null,
        var decategoriapend: String? = null,
        var status: String? = null,
        var cdstatus: Double? = null,
        var cdtipostatus: Double? = null
)