FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/app_portfolio.jar app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]