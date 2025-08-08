FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app_portfolio
ARG app_portfolio-0.0.1.jar
COPY target/app_portfolio-*.jar app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]