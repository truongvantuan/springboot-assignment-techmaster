FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir /springboot-app
WORKDIR /springboot-app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /springboot-app/app.jar
ENTRYPOINT ["java", "-jar"]
CMD ["/springboot-app/app.jar"]