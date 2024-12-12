FROM openjdk:22-jdk-slim

WORKDIR /app

COPY target/GetUsersTestTask-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080 5005

# Command to run the application
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]
