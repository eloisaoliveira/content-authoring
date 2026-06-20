# 📌 API de Usuários, Posts e Comentários

API REST construída com **Spring Boot + MongoDB**, responsável pelo gerenciamento de usuários, posts e comentários.

A aplicação segue uma arquitetura em camadas bem definida, separando responsabilidades entre **API, regras de negócio e acesso a dados**, garantindo escalabilidade e manutenibilidade.

---

## 🚀 Tecnologias

* Java 25
* Spring Boot
* Spring Web
* Spring Data MongoDB
* MongoDB
* Maven

---

## 🧱 Arquitetura da Aplicação

A aplicação segue o padrão:

```
Client → Controller → Service → Repository → MongoDB
```

### 📌 Camadas

* **Controller (REST)**
  Responsável por expor os endpoints e lidar com HTTP

* **Service (Regra de negócio)**
  Onde ficam validações, orquestração e regras da aplicação

* **Repository (Acesso a dados)**
  Interface com o MongoDB via Spring Data

* **Domain (Domínio)**
  Entidades e agregados do sistema

---

## 📂 Estrutura de pastas

```
src/main/java/com/api
│
├── controller        # Endpoints REST
├── service           # Regras de negócio
├── repository        # Interfaces MongoRepository
├── domain            # Entidades (User, Post, Comment)
├── dto               # Objetos de transferência
├── exception         # Tratamento de erros
└── config            # Configurações
```

---

## 🧩 Modelagem do Domínio

### 👤 User

```json
{
  "id": "string",
  "name": "string",
  "email": "string"
}
```

---

### 📝 Post

* Um post pertence a um usuário
* Contém uma lista de comentários (embedded)

```json
{
  "id": "string",
  "date": "date",
  "title": "string",
  "body": "string",
  "author": {
    "id": "string",
    "name": "string"
  },
  "comments": []
}
```

---

### 💬 Comment

```json
{
  "text": "string",
  "date": "date",
  "author": {
    "id": "string",
    "name": "string"
  }
}
```

---

## ⚙️ Configuração do MongoDB

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/workshop_mongo
```

---

## ▶️ Como executar

```bash
mvn clean install
mvn spring-boot:run
```

📍 API disponível em:

```
http://localhost:8080
```

---

## 🔗 Endpoints

### 👤 Usuários

| Método | Rota          | Descrição         |
| ------ | ------------- | ----------------- |
| POST   | `/users`      | Criar usuário     |
| GET    | `/users`      | Listar usuários   |
| GET    | `/users/{id}` | Buscar por ID     |
| PUT    | `/users/{id}` | Atualizar usuário |
| DELETE | `/users/{id}` | Deletar usuário   |

---

### 📝 Posts

| Método | Rota                | Descrição         |
| ------ | ------------------- | ----------------- |
| POST   | `/posts`            | Criar post        |
| GET    | `/posts/{id}`       | Buscar post       |
| GET    | `/users/{id}/posts` | Posts por usuário |

---

### 💬 Comentários

| Método | Rota                   | Descrição            |
| ------ | ---------------------- | -------------------- |
| POST   | `/posts/{id}/comments` | Adicionar comentário |
| GET    | `/posts/{id}/comments` | Listar comentários   |

---

## ⚠️ Tratamento de Exceções

Uso de `@ControllerAdvice` para padronização de erros:

```json
{
  "timestamp": "2026-06-19T12:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Resource not found",
  "path": "/users/123"
}
```

---

## 🧠 Decisões de Arquitetura

* Separação clara de responsabilidades (SRP)
* Uso de DTOs para desacoplamento da API
* MongoDB com documentos embutidos (comments dentro de posts)
* Services como camada central de orquestração
* Repositories desacoplados via Spring Data

---

## 🧪 Boas práticas

* Clean Code
* SOLID (principalmente SRP e DIP)
* Injeção de dependência
* Nomenclatura semântica
* Baixo acoplamento entre camadas

---

## 📈 Melhorias futuras

* Autenticação e autorização com JWT
* Paginação e filtros
* Testes unitários e integração
* Swagger/OpenAPI
* Docker + docker-compose
* Observabilidade (logs + métricas)

---

## 👩‍💻 Autora

Eloisa Oliveira
Backend Developer | Java & Node.js | APIs escaláveis e bem estruturadas 🚀
bem estruturadas 🚀
