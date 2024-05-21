<h1 align="center">CHALLANGE LITER ALURA</h1>
<img align="center" src="/README_FILES/ONE.png" alt="Logo personalizada one">

<p align="center">
    <a href="#sobre">Sobre</a> |
    <a href="#funcionalidades">Funcionalidades</a> |
    <a href="#tecnologias">Tecnologias</a> |
    <a href="#executar">Como Executar</a> |
    <a href="#extras-sugeridos">Extras sugeridos</a> |
    <a href="#resultado">Resultado final</a>
</p>

### Sobre
Este projeto foi desenvolvido como parte do desafio proposto no programa ONE - Oracle Next Education,programa de ensino em Alura/Oracle. O Desafio LiterAlura consiste em um sistema de gerenciamento de livros e autores, onde os usuários podem buscar informações sobre livros, autores, idiomas e realizar diferentes consultas relacionadas a esses dados usando a API gutendex.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- Busca de livros pelo título.
- Listagem de livros registrados.
- Listagem de autores registrados.
- Listagem de autores que estavam vivos em determinado ano.
- Listagem de livros em determinado idioma.

## Tecnologias

O projeto utiliza as seguintes tecnologias e ferramentas:

- Java
- Spring Boot
- JPA (Java Persistence API)
- Jackson (para desserialização de JSON)
- Banco de dados (PostgreSQL)

## Executar

Para executar o projeto localmente, siga estas etapas:

1. Clone este repositório para o seu ambiente local.
2. Certifique-se de ter o JDK (Java Development Kit) e Maven instalado em sua máquina.
3. Abra o prompt no diretorio principal e rode o comando mvn clean install
4. Certifique-se de ter configurado corretamente o ambiente de banco de dados de acordo com as configurações do projeto (Nesse projeto foi usado o PostgreSQL).
5. Você precisará setar algumas variáveis de ambiente, tenha certeza de adicionar todas corretamente.
- JAVA_HOME = Pasta do seu JDK
- M2_HOME = Pasta do seu Maven

Coloque ambos em path adicionando \bin ao final.
- POSTGRES_DB_HOST = Seu host do postgres se está rodando em seu computador será localhost
- POSTGRES_DB_NAME = Nome do banco de dados criado
- POSTGRES_DB_USER = Seu usuario postgres
- POSTGRES_DB_PASSWORD = Sua senha do postgres

## Extras sugeridos
Extras sugeridos pelo desafio:
- Gerando estatísticas: Começamos as sugestões de funcionalidades opcionais lembrando da classe DoubleSummaryStatistics, usada para obter dados estatísticos de um objeto Java. É possível obter esses dados seja de consultas na API ou no banco de dados.
- Top 10 livros mais baixados: Assim como foi apresentado no curso Java: trabalhando com lambdas, streams e Spring Framework, é possível apresentar os dados dos 10 livros mais baixados, sendo uma consulta diretamente feita na API ou no banco de dados.
- Buscar autor por nome: Se você deu uma olhada no site da API, é possível realizar a busca por livro ou autor com a consulta feita com search? - no entanto, neste caso, desafiamos você a realizar a consulta por nome de autor no banco de dados criado para nosso projeto.
- Listar autores com outras consultas: Aqui deixamos como sugestão implementar outras consultas com os atributos de ano de nascimento e falecimento dos autores. Sinta-se livre para explorar e implementar essas características adicionais.


## Resultado

-PROJETO AINDA NÃO FINALIZADO!

## Contribuição

Este projeto foi desenvolvido como parte de um desafio educacional fique a vontade para contribuir, explorar o código-fonte, aprender com ele e adaptá-lo para seus próprios projetos!