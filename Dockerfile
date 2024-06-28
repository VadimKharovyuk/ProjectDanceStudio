# Используем официальный образ OpenJDK для Java 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/ProjectDanceStudio-0.0.1-SNAPSHOT.jar app.jar

# Указываем порт, который будет открыт в контейнере
EXPOSE 2828

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "app.jar"]
