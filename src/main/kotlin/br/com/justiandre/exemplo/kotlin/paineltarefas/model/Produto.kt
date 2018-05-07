package br.com.justiandre.exemplo.kotlin.paineltarefas.model

import org.springframework.data.annotation.Id

data class Produto(
        @Id
        var id: String? = null,
        var nome: String? = null,
        var valor: Double? = null,
        var categoriaPrincipal: String? = null,
        var categoriasSubs: List<String>? = null
)