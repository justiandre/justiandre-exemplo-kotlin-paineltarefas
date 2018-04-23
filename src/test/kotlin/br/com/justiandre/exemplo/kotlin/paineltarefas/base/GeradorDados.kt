package br.com.justiandre.exemplo.kotlin.paineltarefas.base

import br.com.justiandre.exemplo.kotlin.paineltarefas.model.*
import org.apache.commons.lang3.ClassUtils
import org.springframework.stereotype.Component
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaType

@Component
class GeradorDados {

    fun <T : Any> criarDadosEntidade(classe: KClass<T>) = classe.java.newInstance().apply {
        classe.memberProperties
                .map { it as KMutableProperty1<*, *> }
                ?.forEach { it.setter.call(this, criarDadoPorTipoPropriedade(it)) }
    }

    private fun criarDadoPorTipo(propriedadeClass: Type?): Any? = when (propriedadeClass) {
        String::class.javaObjectType -> UUID.randomUUID().toString()
        Double::class.javaObjectType -> Math.random()
        Tarefa::class.javaObjectType -> criarDadosEntidade(Tarefa::class)
        Processo::class.javaObjectType -> criarDadosEntidade(Processo::class)
        Demanda::class.javaObjectType -> criarDadosEntidade(Demanda::class)
        Parte::class.javaObjectType -> criarDadosEntidade(Parte::class)
        Atividade::class.javaObjectType -> criarDadosEntidade(Atividade::class)
        else -> null
    }

    private fun criarDadoPorTipoPropriedade(propriedade: KProperty1<*, *>) =
            criarDadoPorTipo(propriedade.returnType.javaType) ?: criarDadoPorTipoLista(propriedade)

    private fun criarDadoPorTipoLista(propriedade: KProperty1<*, *>) = propriedade
            .takeIf { ClassUtils.isAssignable(propriedade.typeParameters.javaClass, Collection::class.java) }
            ?.let { it.returnType.javaType }
            ?.let { it as ParameterizedType }
            ?.let { criarDadoPorTipo(it.actualTypeArguments.firstOrNull()) }
            ?.let { listOf(it) }
}