FROM eclipse-temurin:21-jdk-jammy
ARG app_portfolio-0.0.1.jar
COPY target/*.jar app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]