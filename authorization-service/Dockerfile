FROM openjdk:17-alpine

WORKDIR /app

COPY /target/authorization-service-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "authorization-service-0.0.1-SNAPSHOT.jar"]