FROM eclipse-temurin:21-jdk-jammy
ARG app_portfolio-0.0.1.jar
COPY target/app_portfolio-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app_portfolio.jar"]