<h1 align="center"> 🏋️‍♂️ACADEMY🏋️‍♂️  </h1>


## 📚Projeto

Este projeto implementa uma API REST com arquitetura de microsserviços para um sistema de gerenciamento de academia. O sistema oferece funcionalidades que incluem controle de usuários, organização de aulas, salas e modalidades, gestão de mensalidades e integração com meios de pagamento externos.

O fluxo principal da aplicação envolve:

1. Cadastro e gerenciamento de usuários da academia.
2. Organização das aulas, salas e modalidades.
3. Integração com a API Stripe para geração de links de pagamento e escuta de notificações via webhooks.
4. Comunicação assíncrona entre microsserviços por meio de RabbitMQ.


<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>


## 🔧Tecnologias

- **Linguagem**: Java
- **Gerenciamento de Dependências**: Gradle
- **Framework**: Spring Boot (Web, Jpa, Security, Validation, Lombok, DevTools)
- **Microsserviços**: Separação dos contextos em múltiplo módulos(Users,Classroom, Payments, Common)
- **Mensageria**: RabbitMQ
- **Banco de Dados**: PostgreSQL
- **Testes**: JUnit 5 e Mockito 
- **Documentação**: Swagger
- **Docker / Docker Compose**

## 💻 Utilização

! Pré-requisitos: Java 17 e Docker !

Para utilizar a aplicação:

1. Inicie o seu docker
2. Clone o Projeto 
3. Abra o Projeto na sua IDE
4. No terminal dentro da IDE, utilize o seguinte comando: docker compose up 

A API pode ser utilizada pelas formas abaixo:
- **Acessando a Documentação da API localmente**: http://localhost:8080/swagger-ui/index.html#/
- **Importando o Arquivo JSON da Collection (Postman ou Insomnia)**: https://github.com/DevDosAnjos/API-REST-ECOMMERCE/blob/main/files/Collection/Ecommerce_collection.json

Inserts Padrões:

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
</details>

<details>
<summary><b></b></summary>
<img src="" alt="">
<img src="" alt="">
</details>

## 👨‍💻Autor
Nathan dos Anjos Gonçalves

https://www.linkedin.com/in/nathan-dos-anjos-gon%C3%A7alves-58849424a/
