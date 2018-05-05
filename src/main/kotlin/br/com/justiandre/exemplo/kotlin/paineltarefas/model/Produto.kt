package br.com.justiandre.exemplo.kotlin.paineltarefas.model

import org.springframework.data.annotation.Id

data class Produto(
        @Id
        var id: String? = null,
        var nome: String? = null,
        var valor: Double? = null,
        var categoriaPrincipal: Categoria? = null,
        var categoriasSubs: List<Categoria>? = null
)

data class Categoria(
        var nome: String? = null
)