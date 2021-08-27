# Build Stage
FROM maven:ibmjava-alpine AS builder
COPY . .
RUN mvn clean package -Dmaven.test.skip

# Launch Stage
FROM openjdk:8-alpine
RUN mkdir /springboot-app
ARG JAVA_FILE=target/*.jar
WORKDIR /springboot-app
COPY --from=builder ${JAVA_FILE} /springboot-app/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/springboot-app/websocket-demo-0.0.1-SNAPSHOT.jar"]