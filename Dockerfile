FROM maven:3.9.9-eclipse-temurin-22 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:22-jdk-slim
WORKDIR /app

COPY --from=build /app/target/GetUsersTestTask-0.0.1-SNAPSHOT.jar /app/app.jar
#COPY target/GetUsersTestTask-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080 5005
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]
