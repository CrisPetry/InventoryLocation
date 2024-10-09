# InventoryLocation

InventoryLocation é uma aplicação de controle de localização de itens no inventário. A aplicação permite gerenciar e monitorar a localização de itens em armazéns, utilizando uma tabela com chaves primárias compostas para identificar cada posição de armazenamento de forma única.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação usada para o desenvolvimento da aplicação.
- **Maven**: Ferramenta de gerenciamento de dependências e build da aplicação.
- **Spring Boot 3.3.4**: Framework para simplificar o desenvolvimento da aplicação Java.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar as informações do inventário.

## Estrutura da Tabela

A tabela **InventoryLocation** possui os seguintes campos:

- `warehouseId`: Identificador do armazém (Parte da chave primária)
- `sectionId`: Identificador da seção (Parte da chave primária)
- `shelfId`: Identificador da prateleira (Parte da chave primária)
- `positionId`: Identificador da posição (Parte da chave primária)
- `itemName`: Nome do item armazenado
- `quantity`: Quantidade de itens armazenados
- `lastUpdate`: Última data de atualização do registro

### Chave Primária Composta

Os campos `warehouseId`, `sectionId`, `shelfId` e `positionId` juntos formam a chave primária composta. Para isso, a aplicação utiliza a anotação `@Embeddable` do Spring, demonstrando como criar uma tabela com chave primária composta no Spring Boot.

![image](https://github.com/user-attachments/assets/7d93e58e-f692-4f97-b499-abf9a7681fa3)


## Endpoints

A aplicação expõe seus endpoints através do Swagger UI. A documentação interativa dos endpoints está disponível em:

- [Swagger UI](http://localhost:8080/swagger-ui.html)

  ![image](https://github.com/user-attachments/assets/f2a57d65-0ece-4990-a2d2-5bec503e36c5)


Alguns dos endpoints disponíveis incluem:

- `GET /inventory`: Lista todos os itens no inventário.
- `POST /inventory`: Adiciona um novo item ao inventário.
- `PUT /inventory/{warehouseId}/{sectionId}/{shelfId}/{positionId}`: Atualiza as informações de um item específico no inventário.
- `DELETE /inventory/{warehouseId}/{sectionId}/{shelfId}/{positionId}`: Remove um item do inventário.

## Configuração

1. **Banco de Dados**: Certifique-se de configurar o PostgreSQL como banco de dados da aplicação. As propriedades de conexão podem ser ajustadas no arquivo `application.properties` ou `application.yml`:

```yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=postgres
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
