# 📋 Projeto Todo List

## 🎯 Descrição
Aplicação de lista de tarefas (**Todo List**) desenvolvida como prática de back-end com Spring Boot, integrando banco de dados PostgreSQL e front-end em HTML, CSS e JavaScript puro.

## 🚀 Funcionalidades
- ✅ Criar tarefas
- ✅ Listar tarefas
- ✅ Atualizar status (concluída/pendente)
- ✅ Excluir tarefas

## 🛠️ Tecnologias Utilizadas
- Java 21 + Spring Boot
- Spring Data JPA
- PostgreSQL
- HTML + CSS + JS (Fetch API)

## 🔧 Como executar o projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seuusuario/todolist
   ```

2. **Crie o banco de dados no PostgreSQL**
   ```sql
   CREATE DATABASE todolistdb;
   ```

3. **Configure o application.properties**
   ```ini
   spring.datasource.url=jdbc:postgresql://localhost:5432/todolistdb
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

4. **Rode o projeto**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Abra o front-end**

   - Se estiver em `src/main/resources/static`, acesse:

     ```
     http://localhost:8080/todo.html
     ```

   - Se estiver salvo fora do projeto, abra o arquivo `todo.html` no navegador.

---

## 👨‍💻 Autor

**Nome:** Samuel Melo  
**Curso:** Licenciatura em Computação (Campus IV / UFPB)
