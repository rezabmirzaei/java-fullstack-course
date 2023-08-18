## Simple demo of a dockerized Spring Boot REST API

Build the image with:
* ``docker build -t <YOUR_DOCKER_USR>/spring-web-demo .``

Run a container of the imsge with:
* ``docker run --name spring-web-demo -e SOME_ENV_VAR='Docker FTW' -dp 8080:8080 <YOUR_DOCKER_USR>/spring-web-demo``

Puch the image to Docker Hub:
* ``docker push <YOUR_DOCKER_USR>/spring-web-demo``

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

### For Gradle, replace _Stage 1_ with

```
## Stage 1: Build the application using Gradle
# https://hub.docker.com/_/gradle/tags
FROM gradle:jdk17-jammy AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY src ./src
RUN gradle clean build --no-daemon
```