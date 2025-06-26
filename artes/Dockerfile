# Usa imagem base do Java 17 com JDK
FROM eclipse-temurin:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado para dentro da imagem
COPY target/artes-0.0.1-SNAPSHOT.jar app.jar

# Porta exposta
EXPOSE 8080

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
