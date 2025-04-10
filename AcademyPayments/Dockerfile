FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/AcademyPayments-0.0.1.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]