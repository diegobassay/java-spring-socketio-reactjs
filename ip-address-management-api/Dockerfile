FROM maven:3.8-openjdk-17 as build

COPY ip-address-management-api/src /home/app/src

COPY ip-address-management-api/pom.xml /home/app

RUN  mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17.0.2-slim-buster

RUN ls -la

COPY --from=build /home/app/target/ip.address.management-0.0.1-SNAPSHOT.jar /usr/local/lib/ip.address.management-0.0.1-SNAPSHOT.jar

RUN echo "America/Sao_Paulo"  > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata

ENTRYPOINT ["java","-XX:MinHeapFreeRatio=20","-XX:MaxHeapFreeRatio=40", "-jar", "/usr/local/lib/ip.address.management-0.0.1-SNAPSHOT.jar"]