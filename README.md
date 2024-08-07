# Projeto CRUD com Spring Framework

Este projeto é um exemplo de uma aplicação CRUD (Create, Read, Update, Delete) utilizando o Spring Framework, JPA, Hibernate e Tomcat como servidor de servlet. O banco de dados H2 foi utilizado para testes.

## Tecnologias Utilizadas

- **Spring Framework**: Usado para construir a aplicação de forma modular e com injeção de dependências.
- **Spring Data JPA**: Facilita o acesso a dados e a manipulação do banco de dados.
- **Hibernate**: Implementação do JPA para mapeamento objeto-relacional.
- **Tomcat**: Servidor de servlet usado para executar a aplicação web.
- **H2 Database**: Banco de dados em memória utilizado para testes.

## Estrutura do Projeto

- **src/main/java**: Contém o código-fonte da aplicação.
  - **com.webservice.toweb**: Pacote principal da aplicação.
    - **resources**: Contém os controladores REST.
    - **entities**: Contém as entidades JPA.
    - **repositories**: Contém os repositórios JPA.
    - **services**: Contém as classes de serviço.
- **src/main/resources**: Contém arquivos de configuração.
  - **application.properties**: Configurações do Spring e do banco de dados H2.

## Configuração

### Banco de Dados H2

O projeto está configurado para utilizar o banco de dados H2 em memória para testes. As configurações do banco de dados podem ser encontradas no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
