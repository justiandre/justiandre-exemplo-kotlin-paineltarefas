package br.com.justiandre.exemplo.kotlin.paineltarefas.it

import br.com.justiandre.exemplo.kotlin.paineltarefas.base.ApplicationBaseIT
import br.com.justiandre.exemplo.kotlin.paineltarefas.base.GeradorDados
import br.com.justiandre.exemplo.kotlin.paineltarefas.model.Tarefa
import br.com.justiandre.exemplo.kotlin.paineltarefas.sdk.TarefaSdk
import org.apache.commons.lang3.StringUtils
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class TarefaIT : ApplicationBaseIT() {

    @Autowired
    private lateinit var tarefaSdk: TarefaSdk

    @Autowired
    private lateinit var geradorDados: GeradorDados

    @Test
    fun `Consultar tarefa por id sem esperar resultado`() {
        val tarefaConsulta = tarefaSdk.findById(UUID.randomUUID().toString())
        Assert.assertNull("Não deveria retornar tarefa", tarefaConsulta)
    }

    @Test
    fun `Consultar tarefa na listagem sem esperar resultado`() {
        val tarefas = tarefaSdk.findAll()
        Assert.assertNotNull("A consulta não deveria retornar o conteudo nulo", tarefas)
    }

    @Test
    fun `Deletar tarefa verificando retorno consulta por id`() {
        assertDeletarTarefaVerificandoNaConsulta(tarefaSdk::findById)
    }

    @Test
    fun `Deletar tarefa verificando retorno consulta listagem`() {
        assertDeletarTarefaVerificandoNaConsulta(::obterTarefaPorIdTarefasListagem)
    }

    @Test
    fun `Salvar tarefa verificando id`() {
        val tarefa = obterNovaTarefaSalva()
        Assert.assertNotNull("Id da tarefa salva não pode estar nulo", tarefa.id)
    }

    @Test
    fun `Salvar tarefa verificando dados consulta por id`() {
        assertSalvarTarefaVerificandoNaConsulta(tarefaSdk::findById)
    }

    @Test
    fun `Salvar tarefa verificando dados consulta listagem`() {
        assertSalvarTarefaVerificandoNaConsulta(::obterTarefaPorIdTarefasListagem)
    }

    private fun assertSalvarTarefaVerificandoNaConsulta(consulta: (String) -> Tarefa?) {
        val tarefa = obterNovaTarefaSalva()
        val tarefaConsulta = consulta(tarefa.id!!)
        Assert.assertNotNull("Tarefa na consulta", tarefaConsulta?.id)
        assertConteudoTarefa(tarefa, tarefaConsulta!!)
    }

    private fun assertDeletarTarefaVerificandoNaConsulta(consultaTarefa: (String) -> Tarefa?) {
        val tarefaId = obterNovaTarefaSalva().id!!
        val tarefaConsultaAntesDelecao = consultaTarefa(tarefaId)
        Assert.assertNotNull("A tarefa deveria ter retornado após seu salvamento", tarefaConsultaAntesDelecao)
        tarefaSdk.deleteById(tarefaId)
        val tarefaConsultaAposDelecao = consultaTarefa(tarefaId)
        Assert.assertNull("Não deveria retornar tarefa porque a mesma foi deletada", tarefaConsultaAposDelecao)
    }

    private fun assertConteudoTarefa(tarefaEsperada: Tarefa, tarefaAtual: Tarefa) {
        tarefaEsperada.id = null
        tarefaAtual.id = null
        Assert.assertEquals("Tarefa esperada está diferente da tarefa atual", tarefaEsperada, tarefaAtual)
    }

    private fun obterTarefaPorIdTarefasListagem(tarefaId: String) = tarefaSdk.findAll().firstOrNull { StringUtils.equalsIgnoreCase(tarefaId, it.id) }

    private fun criarTarefaDadosCompletos() = geradorDados.criarDadosEntidade(Tarefa::class).apply { this.id = null }

    private fun obterNovaTarefaSalva() = criarTarefaDadosCompletos().apply { this.id = tarefaSdk.save(this) }
}
 