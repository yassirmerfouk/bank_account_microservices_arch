FROM openjdk:17

WORKDIR /app

EXPOSE 8082

COPY target/*.jar /app/service.jar

CMD ["java", "-jar", "service.jar"]