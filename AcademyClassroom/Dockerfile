FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/AcademyClassroom-0.0.1.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]