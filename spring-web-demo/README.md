## Simple demo of a dockerized Spring Boot REST API and CI/CD using Github Actions

### Local setup

Clone/fork the project. Open a terminal in the root folder of the project.

Build the image with:
* ``docker build -t <YOUR_DOCKER_USR>/spring-web-demo .``

Run a container of the imsge with:
* ``docker run --name spring-web-demo -e SOME_ENV_VAR='Docker FTW' -dp 8080:8080 <YOUR_DOCKER_USR>/spring-web-demo``

Puch the image to Docker Hub:
* ``docker push <YOUR_DOCKER_USR>/spring-web-demo``

For Gradle, replace _Stage 1_ in the provided Dockerfile with:
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

### Docker file explanation:
```
### Use a base image with Java 17 installed.
# The FROM instruction specifies the base image to use for building the new image.
# Here, it's using the eclipse-temurin image with Java 17 installed.
FROM eclipse-temurin:17-alpine

### Set the working directory in the container to /app.
# The WORKDIR instruction sets the working directory within the container to /app.
# This is the directory where subsequent instructions will be executed.
WORKDIR /app

### Copy the Spring Boot JAR file from the local target/ directory to the /app directory in the container.
# The COPY instruction copies the spring-web-demo-0.0.1-SNAPSHOT.jar file from the local target/ directory 
# into the /app directory in the container and renames it to demo.jar.
COPY target/spring-web-demo-0.0.1-SNAPSHOT.jar /app/demo.jar

### Expose port 8080 on the container.
# This informs Docker that the container will listen on port 8080.
EXPOSE 8080

# Define the command that will be executed when the container starts.
# This runs the Spring Boot app using the Java command with the -jar option to execute demo.jar.
CMD ["java", "-jar", "demo.jar"]
```

### Automated build/push of image to Docker Hub

