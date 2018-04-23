package br.com.justiandre.exemplo.kotlin.paineltarefas

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration(exclude = [(DataSourceAutoConfiguration::class)])
class ApplicationStart

fun main(args: Array<String>) {
    runApplication<ApplicationStart>(*args)
}
