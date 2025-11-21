# 📌 Backend – Task Organizer API

API desenvolvida com Quarkus para gerenciar tarefas semanais, deadlines, status e justificativas de cancelamento.
Este back-end integra com o aplicativo Flutter e fornece os serviços essenciais para CRUD, filtros e lógica de deadline.

## 🚀 Tecnologias Utilizadas

Quarkus 3+

Java 17+

PostgreSQL

Hibernate ORM + Panache

RESTEasy Reactive

Jakarta REST API

Lombok (opcional)

Docker (opcional)

## 📁 Estrutura do Projeto
```css
src/main/java/com/tasks
│
├── controllers/       → Endpoints REST
├── services/          → Regras de negócio
├── repositories/      → Panache (queries)
├── entities/          → Entidades JPA
├── dtos/              → Objetos de entrada e saída
└── utils/             → Verificações e helpers (ex: DeadlineUtils)
```

## 🗄️ Configuração do Banco (application.properties)
```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=postgres
quarkus.datasource.password=postgres
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/tasks
quarkus.hibernate-orm.database.generation=update
quarkus.hibernate-orm.log.sql=true
```
## 🔌 Endpoints
### 📍 Criar Task
```json
POST /tasks

Request Body

{
  "name": "Estudar Flutter",
  "description": "Revisar lista de widgets",
  "type": "Estudo",
  "day": "Segunda",
  "deadline": "2025-01-10T18:00:00",
  "userId": 1
}
```
### 📍 Listar Tasks por Dia
```json
GET /tasks/day/{index}
→ 0 = Domingo, 6 = Sábado
```
### 📍 Atualizar Status
```json
PUT /tasks/updateTaskStatus

Body

{
  "status": "Concluída"
}
```

## Status possíveis:
```java
"Criada"

"Em progresso"

"Bloqueada"

"Concluída"

"Cancelada"
```

## Próximas features

## 📍 Registrar Justificativa (cancelamento por deadline)
```json
PUT /tasks/{id}/cancel

Body

{
  "reason": "Não tive tempo suficiente"
}
```
## ⏰ Deadline Checker – Lógica Interna

### O backend possui suporte para:

1. Validar deadlines

2. Aplicar status automaticamente

3. Receber justificativas

### 🧠 Fluxo de Negócio do Deadline

1. O app consulta a API periodicamente (ou ao abrir o app).

2. Verifica tasks expiradas.

3. O usuário recebe pop-up no Flutter.

Após a escolha:

- Se SIM → API atualiza para Concluída.

- Se NÃO → Flutter envia justificativa → API salva → status vai para Cancelada.

## 🛠️ Rodando o Projeto
### ▶️ Modo desenvolvimento
```terminal
./mvnw quarkus:dev
```
### ▶️ Build nativo (opcional)
```terminal
./mvnw package -Pnative
```
### 🐳 Rodar com Docker (feature futura)
#### Criar imagem:
```docker
docker build -t task-organizer-api .
```
#### Executar:
```docker
docker run -p 8080:8080 task-organizer-api
```
## 📝 Entidade Task (exemplo)
```java
@Entity
public class Task extends PanacheEntity {

    public String name;
    public String description;
    public String type;
    public String day;

    public String status; // Criada, Em progresso, Concluída, Cancelada
    public LocalDateTime deadline;

    public Integer userId;

    @Column(columnDefinition = "TEXT") // feature futura
    public String justification;
}
```
## 🤝 Contribuição

Fork o repositório

Crie sua feature branch

Abra um Pull Request

## 📄 Licença

Este projeto está licenciado sob a MIT License.
