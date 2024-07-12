FROM maven:3.8-openjdk-17 AS build
# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src
# Construir la aplicación
RUN mvn package -DskipTests

# Listar el contenido del directorio target para verificar el nombre del archivo JAR
RUN ls -l target/

# Usar una imagen base de JDK para la ejecución de la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app
# Copiar el JAR construido desde la fase anterior
COPY target/cursos.jar ./cursos.jar
# Copiar el archivo JAR construido desde la fase anterior
#COPY target/cursos.jar /app/cursos.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8092

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "cursos.jar"]