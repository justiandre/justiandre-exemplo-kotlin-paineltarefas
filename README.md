# exemplo-kotlin-paineltarefas

[![Build Status](https://travis-ci.org/justiandre/justiandre-exemplo-kotlin-paineltarefas.svg?branch=master)](https://travis-ci.org/justiandre/justiandre-exemplo-kotlin-paineltarefas)

Projeto de exemplo com API REST de um painel de tarefas, utilizando Kotlin, Spring Boot, Gradle, Swagger etc.

## Tecnologias utilizadas
- [Kotlin](https://kotlinlang.org)
- [Spring Boot](https://projects.spring.io/spring-boot/)
- [Mongo DB](https://www.mongodb.com)
- [Swagger](https://swagger.io)
- [Gradle](https://gradle.org)
- [Docker](https://www.docker.com)

## Vantagens da stack: Kotlin + Spring Boot
- Produtividade
- Linguagem moderna, menos verbosa e com alto nível de abstração
- Orientado a convenção e plugins
- Orientado a micro serviço e cloud, fácil integração com Spring Cloud e Netflix OSS
- Ecossistema de micro serviço, com fácil integração entre ferramentas e conceitos, como, Zipking, GraphQL  etc
- Versionamento de base de dados como padrão e já embutido
- Facil integração com ferramentas, como ElasticSearch, Redis, MongoDb, Neo4j, HazelCast, LDAP etc
- Orientado a testes com fácil criação dos mesmos, com algumas vantagens como base de dados embutida e versionada 
- Fácil integração com Swagger para documentação de API e sendo possível gerá las automaticamente.

## Utilização e Build

Após a inicialização da aplicação, independente da forma, a mesma pode ser acessada ou ter a sua documentação acessada pelo link `http://localhost:PORTA_INICIADA/swagger-ui.html`, exemplo: `http://localhost:9999/swagger-ui.html`.

**OBS:** Ao iniciar a aplicação, também é iniciado um banco de dados, Mongo DB embutido, então não é necessário nenhuma dependência externa para a mesma ser iniciada e acessada.

### Utilização em ambiente local

Localmente o projeto pode ser configurado nas ide’s [IntelliJ](https://www.jetbrains.com/idea/) e [Eclipse](https://www.eclipse.org/ide/), ambas possuem suporte via plugin para Kotlin, Spring Boot e Gradle.

### Build usando artefatos locais (GIT)

**OBS:** Os arquivos e ferramentas de build, estão contidas dentro do projeto, então para execução do build, só é necessário ter o [Java](https://www.oracle.com/br/java/index.html) ou o Docker instalado. 

### Build local com Gradle

```shell
# Execução do build
./gradlew build
# Execução da aplicação
java -jar  build/libs/exemplo.kotlin.paineltarefas-0.0.1-SNAPSHOT.jar
```

**OBS:** Com esses comandos a aplicação será iniciada, na porta 9999, mas isso pode ser alterado, informando o parâmetro: `-Dserver.port=$PORTA_DESEJADA`.

### Build local com Docker

```shell
# Execução do build
docker build -t exemplo.kotlin.paineltarefas:latest .
# Execução da aplicação
docker run -d -p 9999:9999 exemplo.kotlin.paineltarefas:latest
```

**OBS:** Com esses comandos a aplicação será iniciada, na porta 9999,  mas isso pode ser alterado, informando o parâmetro docker: `-p $PORTA_DESEJADA:9999`.

### Utilização com Docker (imagem remota do DockerHub)

```shell
# Execução da aplicação
docker run -d -p 9999:9999 justiandre/exemplo-kotlin-paineltarefas:master
```

**OBS:** Com esse comando a aplicação será iniciada, na porta 9999, mas isso pode ser alterado, informando o parâmetro docker: `-p $PORTA_DESEJADA:9999`.


## Arquivo e artefatos do projeto

| Arquivo ou diretório  |  Descrição |
| ------------ | ------------ |
| gradle/*, settings.gradle, gradlew.sh, gradlew.bat | Arquivos e diretórios de instalação do Gradle, com eles no projeto, não é necessário instalar o Gradle separadamente |
|  build.gradle | Arquivo com as configurações de build do Gradle |
| Dockerfile | Arquivo com as configurações para criação da imagem Docker, nesse Dockerfile é utilizado a estratégia multi-stage builds |
| .travis.yml  | Arquivo com as configurações de build contínuo, no caso desse projeto possui as configurações de build, testes e push da imagem Docker para o DockerHub |
| src/main/ | Diretório com os fonts Kotlin da aplicação |
| src/main/**/endpoint/ | Diretório com os fonts referentes aos endpoints da aplicação |
| src/main/**/endpoint/TarefaEndpoint.kt | Endpoint da entidade Tarefa |
| src/main/**/configuration/ | Diretório com os fonts referentes a configuração da aplicação |
| src/main/**/configuration/SwaggerConfig.kt | Configuração de geração automática da documentação em Swagger |
| src/main/**/service/ | Diretório com os fonts referentes aos serviços da aplicação |
| src/main/**/service/TarefaService.kt | Serviço da entidade Tarefa |
| src/main/**/repository/api/ | Diretório com os fonts referentes aos repositórios da aplicação |
| src/main/**/repository/api/TarefaRepository.kt | Repositório da entidade Tarefa |
| src/main/**/ApplicationStart.kt | Classe responsável pela inicialização da aplicação |
| src/main/**/entity/ | Diretório com os fonts referentes às entidades da aplicação |
| src/main/**/entity/Tarefa.kt | Entidade de Tarefa |
| src/main/resources | Diretório com as configurações da aplicação |
| src/main/resources/application.yml | Arquivo de configuração do Spring Boot |
| src/test/ | Diretório com os fonts de teste da aplicação |
| src/test/**/it | Diretório com os fonts de teste de integração da aplicação |
| src/test/**/it/TarefaIT.kt | Classe com os testes de integração do serviço de tarefa |
| src/test/**/base/ | Diretório para criação das coisas reutilizáveis da camada de teste |
| src/test/**/base/GeradorDados.kt | Classe responsável pela geração de dados randômicos para teste |
| src/test/**/base/ApplicationBaseIT.kt | Classe base das classes de teste de integração |
| src/test/**/sdk/ | Pacote com os sdks de acesso aos serviços da aplicação |
| src/test/**/sdk/TarefaSdk.kt | Sdk de acesso aos serviços de tarefa |


## Observação
Nesse projeto poderia ser utilizado outras estratégias para diminuir a verbosidade da criação da API REST, com a ferramenta [Spring Data Rest](https://projects.spring.io/spring-data-rest/), mas foi feito manualmente usando Spring Data e Spring Rest para validar a utilização manual com Kotlin.


