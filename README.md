# Workshop MongoDB com Spring Boot

Este projeto é uma aplicação web desenvolvida em Java com Spring Boot, que implementa uma API RESTful simulando uma rede social simples.

A ideia principal é explorar o uso de um banco de dados NoSQL (MongoDB), modelando usuários, posts e comentários em um formato orientado a documentos.

# Funcionalidades

👤 Usuários: cadastro, listagem, atualização e remoção.

📝 Posts: criação e associação de posts a usuários.

💬 Comentários: inclusão de comentários em posts, vinculados ao autor.

🔎 Consultas personalizadas: busca de posts por título, texto ou intervalo de datas.

⚠️ Tratamento de exceções com respostas padronizadas para erros comuns.

🛠 Tecnologias utilizadas

☕ Java 17+

🌱 Spring Boot

🗄️ Spring Data MongoDB

📦 Maven

# Como executar

1 - Instale o MongoDB localmente ou utilize um cluster na nuvem.

2 -Clone o repositório: git clone https://github.com/Romulo567/workshop-mongo.git

3 - Acesse o diretório do projeto: cd workshopmongo

4 - Execute o projeto com Maven: ./mvnw spring-boot:run


# Exemplos de endpoints

GET /users → lista todos os usuários

POST /users → cadastra um novo usuário

GET /posts/{id} → busca um post por ID

GET /posts/titlesearch?text=palavra → busca posts por título
