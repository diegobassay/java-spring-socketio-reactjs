# ip-address-management-api

Desafio usando SpringBoot e SocketIO

API backend usada para simular um IPAM (IP Address Management)

## Pré-requisitos

* Docker >= version 20.10.12, build e91ed57
* Mysql instalado

## Tecnologias

* Java 8

## Para executar o projeto
Para construir e executar o projeto é necessário executar os comandos abaixo na raiz do projeto:
```
docker build -t ip-address-management-api -f Dockerfile .

docker run --rm -p 8080:8080 --name ip-address-management-api-containner ip-address-management-api:latest
```

## Para executar os testes
Para executar use os seguintes commandos para entrar no containner e iniciar os testes:
```
docker run -it --rm --name ip-address-management-api-containner java ./mvnw test
```

![vnc](https://github.com/diegobassay/java-spring-socketio-reactjs/blob/main/screenshots/screenshot2.png)


## Para utilizar com Java
Para executar com Java usado os seguintes comandos:
```
./mvnw clean install
./mvnw spring-boot:run
```


