# Literalura

Literalura é um projeto proposto pelo programa ONE BR Back End com o consumo da API Gutendex. O projeto permite buscar livros, listar livros registrados, listar autores registrados, listar autores vivos em um determinado ano e listar livros em um determinado idioma.

## Descrição

Este projeto foi desenvolvido para gerenciar livros e autores utilizando o framework Spring Boot. Ele permite realizar buscas por livros utilizando uma API externa(Gutendex), armazenar os livros e autores em um banco de dados PostgreSQL e realizar diversas consultas no banco de dados.

## Tecnologias Utilizadas

- **Java 22.0.1**
- **Spring Boot 3.3.1**
- **PostgreSQL**
- **Maven**

## Instalação

### Pré-requisitos

- Java 22.0.1 instalado
- PostgreSQL instalado e configurado
- Maven instalado

### Passos

1. Clone o repositório:

   ```sh
   git clone https://github.com/seu-usuario/literalura.git
2. Navegue até o diretório do projeto:
    ```sh
    cd literalura
3. Configure o banco de dados no arquivo "application.properties:"
    
   Tenha variáveis de ambiente configuradas com seus dados para funcionar.
    ```sh
    spring.application.name=literalura
    spring.datasource.url=jdbc:postgresql://${DB_HOST}/literalura
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASSWORD}
    spring.datasource.driver-class-name=org.postgresql.Driver
    hibernate.dialect=org.hibernate.dialect.HSQLDialect

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=false
    spring.jpa.format-sql=true

5. Compile e execute o projeto
   ```sh
   mvn spring-boot:run
## Uso: 
Ao iniciar a aplicação, você verá o menu principal com as seguintes opções:
    
    ===================================================================================================================
    Escolha o número de sua opção.
    1 - Buscar livro pelo título
    2 - Listar livros registrados
    3 - Listar autores registrados
    4 - Listar autores vivos em determinado ano
    5 - Listar livros em determinado idioma
    0 - Sair
    ===================================================================================================================
## Funcionalidades:
Buscar livro pelo título: Permite buscar um livro pelo título utilizando uma API externa e salvar no banco de dados.

Listar livros registrados: Exibe todos os livros registrados no banco de dados.

Listar autores registrados: Exibe todos os autores registrados no banco de dados.

Listar autores vivos em determinado ano: Exibe todos os autores que estavam vivos em um determinado ano.

Listar livros em determinado idioma: Exibe todos os livros registrados no banco de dados em um determinado idioma.

## Exemplo de Uso
Para buscar um livro pelo título:

  1. Escolha a opção 1.
  
  2. Digite o título do livro que deseja buscar.
  
  3. O sistema buscará o livro na API externa e o salvará no banco de dados se não estiver registrado.
  
  ## Idiomas Suportados
  
  Ao listar livros por idioma, você pode usar os seguintes códigos de idioma:

es - Espanhol

en - Inglês

fr - Francês

pt - Português

## Contribuição
1. Fork o projeto
2. Crie uma branch para sua feature (git checkout -b feature/AmazingFeature)
3. Faça o commit das suas alterações (git commit -m 'Add some AmazingFeature')
4. Dê push para a branch (git push origin feature/AmazingFeature)
5. Abra um Pull Request
   
## Licença
Distribuído sob a licença MIT. Veja LICENSE para mais informações.

## Badge do desafio
<img src="https://github.com/oVictorTorres/Literalura/blob/main/literalura/literalura/badge%20literalura.png?raw=true">

## Funcionalidades a serem inseridas 
- Gerar estatísticas

- Top 10 livros mais baixados

- Buscar autor por nome

- Listar autores com outras consultas
