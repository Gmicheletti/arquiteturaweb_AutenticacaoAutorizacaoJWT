# arquiteturaweb_AutenticacaoAutorizacaoJWT

# Autenticação e Autorização com JWT - Spring Boot

Este projeto demonstra uma arquitetura web utilizando Spring Boot para autenticação e autorização via JWT (JSON Web Token), com banco de dados H2 em memória, documentação Swagger e testes de carga com JMeter.

## 🧱 Tecnologias

- Java 17
- Spring Boot
- Spring Security
- JWT
- H2 Database
- Swagger (Springdoc OpenAPI)
- Maven
- JMeter

---

## 🚀 Como clonar e executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Gmicheletti/arquiteturaweb_AutenticacaoAutorizacaoJWT.git
cd arquiteturaweb_AutenticacaoAutorizacaoJWT
```

### 2. Abrir o projeto em uma IDE

Você pode usar o IntelliJ IDEA, Eclipse ou VS Code com suporte a projetos Maven.

### 3. Executar a aplicação

Certifique-se de ter o Java 17 instalado.

#### Usando Maven

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn clean install
java -jar target/authserver-0.0.1-SNAPSHOT.jar
```

A aplicação será iniciada na porta padrão `http://localhost:8080`.

---

## 🧪 Acessar o Console do H2

Após a aplicação estar rodando, acesse:

🔗 `http://localhost:8080/h2-console`

**Configurações padrão:**

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** *(em branco)*

Clique em "Connect".

---

## 📑 Acessar a Documentação Swagger (OpenAPI)

Acesse:

🔗 `http://localhost:8080/swagger-ui.html`

Ou diretamente:

🔗 `http://localhost:8080/swagger-ui/index.html`

Você verá a interface interativa para testar os endpoints da API.

---

## 🔐 Fluxo de autenticação JWT

1. Faça `POST` para `/api/v1/auth/login` com login e senha válidos.
2. Receba o `access_token` e `refresh_token`.
3. Utilize o `access_token` no header `Authorization: Bearer {token}` para acessar endpoints protegidos.

---

## 📈 Executar Testes de Carga com JMeter

1. Instale o [Apache JMeter](https://jmeter.apache.org/download_jmeter.cgi).
2. Abra o arquivo de teste `jmeter/testes-autenticacao.jmx` incluído no projeto.
3. Atualize a URL base, se necessário (`localhost:8080`).
4. Clique no botão **Start** para rodar os testes de carga.

---

## ✅ Requisitos

- Java 17
- Maven
- Apache JMeter

---
