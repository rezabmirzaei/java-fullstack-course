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
