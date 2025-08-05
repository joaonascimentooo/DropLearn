# ✨ DropLearn

![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-blue.svg)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-brightgreen)
![Java](https://img.shields.io/badge/Java-21%2B-orange.svg)

DropLearn é a API backend para uma plataforma de micro-aprendizagem, onde o conhecimento é entregue em pequenas "pílulas". O sistema é construído com uma arquitetura moderna, segura e escalável, utilizando Spring Boot e autenticação via JWT.

## 📚 Funcionalidades Principais

* **Autenticação Segura**: Sistema completo de registro e login com senhas criptografadas (BCrypt).
* **Autorização com JWT**: Acesso a rotas protegido por JSON Web Tokens, garantindo que apenas usuários autenticados possam interagir com a API.
* **Gerenciamento de Papéis (Roles)**: Arquitetura preparada para diferenciar permissões entre tipos de usuários (ex: `USER`, `ADMIN`).
* **API RESTful**: Endpoints claros e bem definidos seguindo as melhores práticas do design de APIs.
* **Modelo de Domínio Desacoplado**: A entidade de usuário (`Usuario`) é totalmente independente do framework Spring Security, seguindo princípios de arquitetura limpa.

## 🔧 Tecnologias Utilizadas

* **Backend**: [Spring Boot](https://spring.io/projects/spring-boot) 3.x
* **Segurança**: [Spring Security](https://spring.io/projects/spring-security) 6.x
* **Linguagem**: [Java](https.www.java.com/) 21+
* **Persistência**: [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* **Banco de Dados**: [PostGreSQL Database](https://www.postgreSQL.com/) (para ambiente de desenvolvimento)
* **Autenticação**: [Auth0 Java JWT](https://github.com/auth0/java-jwt)
* **Build Tool**: [Maven](https://maven.apache.org/)
* **Utilitários**: [Lombok](https://projectlombok.org/)

## 🚀 Como Começar

Siga estas instruções para ter uma cópia do projeto rodando na sua máquina local para desenvolvimento e testes.

### Pré-requisitos

* JDK 21 ou superior instalado.
* Maven 3.6 ou superior instalado.
* Sua IDE favorita (IntelliJ IDEA, VS Code, Eclipse).

### Instalação e Configuração

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/droplearn.git](https://github.com/seu-usuario/droplearn.git)
    cd droplearn
    ```

2.  **Configure a Chave Secreta do JWT:**
    Abra o arquivo `src/main/resources/application.properties`. Você encontrará a seguinte linha:

    ```properties
    application.security.jwt.secret-key=seu-segredo-super-forte-e-longo-aqui
    ```

    > **⚠️ Importante:** Substitua o valor por uma chave secreta forte e única. Você pode gerar uma online usando um gerador de senhas complexas. **Nunca** suba sua chave secreta real para um repositório público.

3.  **Execute a aplicação:**
    Use o Maven para compilar o projeto e iniciar o servidor.

    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

## 📝 Uso da API

A seguir, a documentação dos endpoints públicos de autenticação.

### Endpoints de Autenticação

| Rota                     | Método | Descrição                    |
| ------------------------ | ------ | ------------------------------ |
| `/api/v1/auth/register` | `POST` | Registra um novo usuário.      |
| `/api/v1/auth/login`     | `POST` | Autentica um usuário existente. |

---

#### 1. Registrar um Novo Usuário

**Requisição:** `POST /api/v1/auth/register`

**Corpo (Body):**
```json
{
    "nome": "Seu Nome",
    "email": "seu.email@exemplo.com",
    "senha": "sua_senha_segura",
    "role": "USER"
}
