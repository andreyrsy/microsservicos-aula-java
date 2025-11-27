# 🚀 Projeto de Microsserviços: Pedidos & Produtos

Este repositório contém o meu primeiro projeto prático explorando o universo dos **Microsserviços** com **Spring Boot**. O objetivo foi criar dois serviços independentes que se comunicam entre si, simulando um cenário real de e-commerce.

## 💡 Sobre o Projeto

Durante o desenvolvimento, mergulhei nos conceitos fundamentais de arquitetura de microsserviços. O que mais me surpreendeu foi a experiência de criar duas aplicações Spring Boot distintas e fazê-las "conversar".

O desafio de orquestrar os serviços em portas diferentes (**8081** e **8082**) e estabelecer a comunicação entre eles foi uma grande oportunidade de aprendizado.

## 🏗️ Arquitetura

O sistema é composto por dois microsserviços principais:

### 1. `msprodutos` (Serviço de Produtos)
- **Porta**: `8081`
- **Responsabilidade**: Gerenciar o catálogo de produtos.
- **Banco de Dados**: PostgreSQL (`produtodb`)

### 2. `mspedidos` (Serviço de Pedidos)
- **Porta**: `8082`
- **Responsabilidade**: Gerenciar a criação de pedidos.
- **Comunicação**: Utiliza `WebClient` para consultar a existência e detalhes do produto no serviço `msprodutos` antes de fechar um pedido.
- **Banco de Dados**: PostgreSQL (`pedidodb`)

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Spring Boot** (Web, Data JPA, Validation)
- **Spring WebFlux** (WebClient para comunicação entre microsserviços)
- **PostgreSQL** (Banco de dados relacional)
- **Flyway** (Migração de banco de dados)
- **Maven** (Gerenciamento de dependências)

## 🔌 Endpoints

### Serviço de Produtos (`msprodutos` - 8081)

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/produtos` | Lista todos os produtos |
| `GET` | `/produtos/{id}` | Busca um produto por ID |
| `POST` | `/produtos` | Cadastra um novo produto |

### Serviço de Pedidos (`mspedidos` - 8082)

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/pedidos` | Cria um novo pedido (Requer `produtoId` e `quantidade` como parâmetros) |

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL rodando localmente (com os bancos `produtodb` e `pedidodb` criados)

### Passo a Passo

1. **Inicie o serviço de Produtos**:
   Navegue até a pasta `msprodutos` e execute:
   ```bash
   ./mvnw spring-boot:run
   ```
   O serviço estará disponível em `http://localhost:8081`.

2. **Inicie o serviço de Pedidos**:
   Navegue até a pasta `mspedidos` e execute:
   ```bash
   ./mvnw spring-boot:run
   ```
   O serviço estará disponível em `http://localhost:8082`.

3. **Teste a Integração**:
   - Crie um produto no `msprodutos`.
   - Tente criar um pedido no `mspedidos` usando o ID do produto criado.

---
*Desenvolvido como parte dos meus estudos em Arquitetura de Software e Spring Boot.*
