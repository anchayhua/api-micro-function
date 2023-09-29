# Usa una imagen base de Java 17 (OpenJDK)
FROM openjdk:17-alpine

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR de tu aplicación construida por Gradle al contenedor
COPY build/libs/api-funtion-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que tu aplicación Spring Boot escucha (puerto 8080 por defecto)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]


# # Utiliza una imagen base que incluye Java y Gradle
# FROM gradle:7.3.3-jdk17 AS build

# # Establece el directorio de trabajo en /home/gradle
# WORKDIR /home/gradle

# # Instala Gradle en la imagen (si no está incluido)
# USER root
# RUN apt-get update && apt-get install -y gradle
# USER gradle

# # Copia el archivo build.gradle y settings.gradle a la etapa de construcción
# COPY build.gradle settings.gradle ./

# # Copia el directorio src al contenedor
# COPY src src

# # Construye el proyecto utilizando Gradle
# RUN gradle build --no-daemon --stacktrace

# # Etapa final: Utiliza una imagen base de Java 17 (OpenJDK) para la imagen final
# FROM openjdk:17-alpine

# # Establece el directorio de trabajo en /app
# WORKDIR /app

# # Copia el archivo JAR construido desde la etapa de construcción al contenedor
# COPY --from=build /home/gradle/build/libs/api-funtion-0.0.1-SNAPSHOT.jar app.jar

# # Expone el puerto en el que tu aplicación Spring Boot escucha (puerto 8080 por defecto)
# EXPOSE 8080

# # Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
# CMD ["java", "-jar", "app.jar"]
