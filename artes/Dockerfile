FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/artes-0.0.1-SNAPSHOT.jar /app/artes.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "artes.jar"]
