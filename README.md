# Desafio Tech - Cadastro de Agências

Este projeto é uma API REST desenvolvida em Java com Spring Boot para cadastro e consulta de agências bancárias, incluindo cálculo de distância entre localizações e tratamento de zonas geográficas.

## Funcionalidades

- Cadastro de novas agências bancárias
- Consulta de agências por zona
- Cálculo da distância entre uma localização informada e as agências de uma zona
- Tratamento de exceções e respostas padronizadas

## Tecnologias Utilizadas

- Java 25
- Spring Boot
- Spring Data JPA
- H2 Database
- JUnit 5 e Mockito (testes unitários)

## Endpoints Principais

### Cadastro de Agência
- **POST** `/desafio/cadastrar`
- Corpo da requisição (JSON):
  ```json
  {
	 "nomeAgencia": "Agência Central",
	 "posX": -46.6333,
	 "posY": -23.5505,
	 "idZona": 1
  }
  ```
- Resposta: Dados da agência cadastrada

### Consulta de Distância
- **GET** `/desafio/distancia?posX={longitude}&posY={latitude}&zona={idZona}`
- Resposta: Lista de agências da zona e suas distâncias em relação à posição informada

## Como Executar

1. **Pré-requisitos:**
	- Java 25
	- Maven

2. **Clone o repositório:**
	```bash
	git clone <url-do-repositorio>
	cd desafio-tech-cadastro-agencias
	```

3. **Execute a aplicação:**
	```bash
	./mvnw spring-boot:run
	```
	ou no Windows:
	```bash
	mvnw.cmd spring-boot:run
	```

4. **Acesse a API:**
	- A aplicação estará disponível em `http://localhost:8080`

## Testes

Para rodar os testes unitários:
```bash
./mvnw test
```

## Estrutura do Projeto

- `src/main/java` - Código fonte da aplicação
- `src/test/java` - Testes unitários
- `src/main/resources/sql` - Scripts de banco de dados (schema e dados)

## Observações
- O banco de dados padrão é o H2 em memória, facilitando testes e desenvolvimento.
- O projeto segue boas práticas de organização e tratamento de exceções.

## Autor
- Felipe Coelho

---
# desafio-tech-cadastro-agencias
Desafio técnico para criar uma api rest que cadastra e recupera agências. 
