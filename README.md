# Test-Backend

api para cadastro de clientes e pets.

  - Feito com springboot e dependências Maven
  - Conectado à o banco de dados MySQL e com persitência Jpa e hibernate

# New Features!

 - Testes para o ClienteService

Na Classe ClienteServiceTest foram feitos testes para listar,cadastar e deletar clientes.

### Required

- Jdk  11 
- jUnit 4.13
- jUnit 5.7.0
- hibernate-validator 6.0.10
- Mockito
- Maven
- MySQL

### Installation

Para o funcionamento correto todos os requerimentos devem estar devidamente instalados.

Para clonar esse repositório em sua máquina  basta abrir seu gitbash ou seu terminal linux com o git instalado e digitar o seguinte comando:
```sh
$ git pull
```
Para você contribuir com esse repositório...

```sh
$ git clone
```

### Como rodar
Entre no banco de dados MySQL e digite
```sh
$ create database teste_backend;
```
 criado o banco de dados você não irá precisar colocar as variáveis do models pois irão se autodefinir(configurações no dataConfig);
 
 -  Depois é só dar um run na aplicação.

### Requests no navegador ou no Postman

- server.port = 8080
```
Verify the deployment by navigating to your server address in your preferred browser.

```sh
    localhost:8080/api/v1/cliente/listar 
    localhost:8080/api/v1/cliente/cadastrar
    localhost:8080/api/v1/cliente/pesquisar/{id} 
    localhost:8080/api/v1/cliente/pesquisar/nome/{nome}
    localhost:8080/api/v1/cliente/pesquisar/email/{email}
    localhost:8080/api/v1/cliente/atualizar/{id}
    localhost:8080/api/v1/cliente/deletar/{id}
```
