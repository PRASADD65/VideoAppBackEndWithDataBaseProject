# Stage 1: Build the Spring Boot application using Maven
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copy the project files
COPY . .

# Run Maven build (forces output to a known location)
RUN mvn clean package -DskipTests && ls -lah target/

# Stage 2: Use a lightweight JDK to run the built application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Ensure the JAR file path is correct
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
