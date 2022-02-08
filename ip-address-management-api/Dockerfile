FROM maven:3.8-openjdk-17 as build

RUN ls -la

COPY ip-address-management-api/src /home/app/src

COPY ip-address-management-api/pom.xml /home/app

RUN  mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17.0.2-slim-buster

COPY --from=build /home/app/target/ip.address.management-0.0.1-SNAPSHOT /usr/local/lib/ip.address.management-0.0.1-SNAPSHOT

RUN echo "America/Sao_Paulo"  > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata

ENTRYPOINT ["java","-XX:MinHeapFreeRatio=20","-XX:MaxHeapFreeRatio=40", "-jar", "/usr/local/lib/ip.address.management-0.0.1-SNAPSHOT"]