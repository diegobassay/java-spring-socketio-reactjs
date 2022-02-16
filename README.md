# java-spring-socketio-reactjs

Desafio usando SpringBoot, ReactJs e SocketIO

Aplicativo com usado para simular um IPAM (IP Address Management)

## Pré-requisitos

* Docker >= version 20.10.12, build e91ed57
* Docker Compose >= version 1.26.0, build d4451659

## Tecnologias

* Java 8
* MySql 8
* ReactJS 17.0 (Functional Components)
* Typescript 4

## Para executar o projeto
Para construir e executar o projeto é necessário executar os comandos abaixo na raiz do projeto:
```
docker-compose build
docker-compose up
```
Acessar o endereço: http://localhost:3000

![vnc](https://github.com/diegobassay/java-spring-socketio-reactjs/blob/main/screenshots/screenshot1.png)


## Para executar os testes
O sistema foi construído usando TDD e possui 90% de cobertura, os relatórios podem ser encontrados em:
```
target/site/jacoco/index.html
```
Para executar use os seguintes commandos para entrar no containner e iniciar os testes:
```
docker exec -it ip-address-management-api bash
cd app
./mvnw test
```

![vnc](https://github.com/diegobassay/java-spring-socketio-reactjs/blob/main/screenshots/screenshot2.png)


## Para utilizar a API
A api pode ser utilizada pelo Swagger 3 no endereço abaixo:
O sistema foi construído usando TDD e possui 90% de cobertura, os relatórios podem ser encontrados em:
```
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/docs
```

ou pode se utilizar a postman collection adicionada ao projeto 'ip-address-management-api'

```
ip-address-management-api/api.postman_collection.json
```

![vnc](https://github.com/diegobassay/java-spring-socketio-reactjs/blob/main/screenshots/screenshot3.png)


