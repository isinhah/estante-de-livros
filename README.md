# Estante de Livros

![NPM](https://img.shields.io/npm/l/react)

# Sobre o projeto

Sistema de armazenamento de livros, com objetivo de organizar os livros lidos pelo usuário.

# Funcionalidades

- Manipulação dos livros por meio das operações básicas CRUD no Banco de dados.
- Utilização do JDBC para realizar conexão, comunicação e operações entre o Banco de dados e a aplicação.

## 1. Menu de opções

![diagrama](/assets/menu.jpg)

## 2. Listar livros

![diagrama](/assets/livros_armazenados.jpg)

## 3. Cadastrar livro

![diagrama](/assets/adicionar_livro.jpg)

# Tecnologias utilizadas

## Backend

- Java
- JDBC
- MySQL

# Modelo Conceitual

![diagrama](/assets/diagrama.png)

# Como executar o projeto

Pré-requisitos: Java 17 e MySQLConnector

```bash
# Clone o repositório
    git clone https://github.com/isinhah/livraria.git
# Entre na pasta do projeto
    cd livraria
# Configure as propriedades do banco de dados na classe App
    "jdbc:mysql://localhost:3306/livrariajdbc?user=root&password=admin"
# Execute o projeto
    class App
```

# Autor

Isabel Henrique

https://www.linkedin.com/in/isabel-henrique/
