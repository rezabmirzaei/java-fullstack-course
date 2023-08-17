### Multi stage Dockerfile for building the application using maven

```
## Stage 1: Build the application using Maven
# https://hub.docker.com/_/maven/tags
FROM maven:3.9.3-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

## Stage 2: Create the image
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=build /app/target/spring-web-demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8080
CMD ["java", "-jar", "demo.jar"]
```