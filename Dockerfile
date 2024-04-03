FROM amazoncorretto:22.0.0-alpine3.19 AS builder

WORKDIR /app
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src
RUN chmod +x gradlew
RUN ./gradlew build

FROM amazoncorretto:22.0.0-alpine3.19
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]

#CMD ["./gradlew", "clean", "bootJar"]
#RUN ls -la
#COPY build/libs/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]