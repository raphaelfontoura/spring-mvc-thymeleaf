

### Rodando o projeto

> Subindo o banco de dados

Utilizando o docker:
```bash
$ docker run -d -p 3306:3306 --env MYSQL_ROOT_PASSWORD=root --name alura-mariadb mariadb:latest
```
> Rodando o projeto localmente

Verifique a versão do java

```bash
$ java --version
```
A versão utilizada no projeto foi JAVA 17.

Rodando com o maven:

```bash
$ ./mvnw install

$ ./mvnw spring-boot:run
```
Acesse a aplicação pelo browser no link:
> http://localhost:8080/home

