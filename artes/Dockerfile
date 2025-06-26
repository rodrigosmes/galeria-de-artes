<<<<<<< HEAD
FROM eclipse-temurin:21-jdk-alpine
=======
# Usa imagem base do Java 17 com JDK
FROM eclipse-temurin:21-jdk-alpine

# Diretório de trabalho dentro do container
>>>>>>> 63cfad2be00cc5e1e742c5918390dbfd2f6f88fd
WORKDIR /app
COPY target/artes-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "app.jar"]
