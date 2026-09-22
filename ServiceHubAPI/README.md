# ServiceHub API

ServiceHub API é uma API REST para gerenciamento de serviços, desenvolvida em Java com Spring Boot. O projeto tem como objetivo permitir o cadastro, consulta, atualização e exclusão de serviços, seguindo boas práticas de arquitetura e documentação.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI (Swagger UI)
- Lombok
- Maven

## Funcionalidades

- Cadastro de serviços
- Listagem de serviços
- Busca por ID
- Atualização de serviço
- Exclusão de serviço
- Documentação interativa via Swagger

## Estrutura principal

- `com.servicehub.api.controller` - Endpoints REST
- `com.servicehub.api.service` - Lógica de negócio
- `com.servicehub.api.repository` - Repositórios JPA
- `com.servicehub.api.model` - Entidades
- `com.servicehub.api.dto` - Objetos de entrada e saída
- `com.servicehub.api.exception` - Tratamento global de exceções

## Pré-requisitos

Antes de rodar o projeto, certifique-se de que você tenha instalado:

- Java 17+
- Maven
- PostgreSQL em execução

## Configuração do banco de dados

No arquivo `src/main/resources/application.properties`, configure a conexão com o PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/servicehub
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
```

Crie o banco de dados `servicehub` no PostgreSQL antes de iniciar a aplicação.

## Rodando localmente

### Opção 1: via Maven

Na raiz do projeto, execute:

```bash
mvn spring-boot:run
```

A aplicação iniciará em:

```text
http://localhost:8080
```

### Opção 2: empacotar e executar

```bash
mvn clean package
java -jar target/ServiceHubAPI-0.0.1-SNAPSHOT.jar
```

### Opção 3: via Docker Compose

Na raiz do projeto, execute:

```bash
docker-compose up --build
```

Esse comando irá subir:
- PostgreSQL na porta `5432`
- API Spring Boot na porta `8080`

Para encerrar os containers:

```bash
docker-compose down
```

## Documentação Swagger

Após iniciar a aplicação, acesse a documentação interativa no navegador:

```text
http://localhost:8080/swagger-ui.html
```

A API também expõe a documentação OpenAPI em:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints principais

### Serviços

- `POST /api/servicos` - Cadastrar serviço
- `GET /api/servicos` - Listar serviços
- `GET /api/servicos/{id}` - Buscar serviço por ID
- `PUT /api/servicos/{id}` - Atualizar serviço
- `DELETE /api/servicos/{id}` - Excluir serviço

## Observações

- O projeto já está preparado para uso com arquitetura em camadas, DTOs e tratamento de exceções.
- As respostas HTTP seguem as boas práticas, retornando `201`, `200`, `204` e erro estruturado em `400` e `404`.
