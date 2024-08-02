FROM alpine:latest
RUN apk add openjdk21
COPY target/CatsApi-0.0.1.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]