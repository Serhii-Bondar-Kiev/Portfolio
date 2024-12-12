FROM maven:3.9.9-openjdk-22 AS build
WORKDIR /app

# Copy the source code into the container
COPY pom.xml .
COPY src ./src

# Build the application and skip tests
RUN mvn clean package -DskipTests


# Use a base image with Java pre-installed
FROM openjdk:c-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file to the container
COPY target/GetUsersTestTask-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
