# Stage 1: Build the JAR using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies first (cache optimization)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the project
COPY . .

## Build the Spring Boot application (skip tests for speed)
#RUN mvn clean package -DskipTests

# Stage 2: Run the JAR using lightweight JDK image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy built jar from previous stage
COPY --from=build /app/target/*.jar air-0.0.1-SNAPSHOT.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "air-0.0.1-SNAPSHOT.jar"]
