FROM amazoncorretto:22.0.0-alpine3.19

WORKDIR /app
CMD ["./gradlew", "clean", "bootJar"]
RUN ls -la
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]