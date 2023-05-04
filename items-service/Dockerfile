FROM openjdk:17-alpine

WORKDIR /app

COPY /target/items-service-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "items-service-0.0.1-SNAPSHOT.jar"]