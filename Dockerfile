# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the source code
COPY pom.xml .
COPY src/ ./src/

# Build the application
RUN apt-get update && apt-get install -y maven
RUN mvn clean install

# Copy the built JAR file
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]

