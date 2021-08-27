FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir /root/springboot-app
WORKDIR /root/springboot-app
ARG APP_PATH=/root/springboot-app
ARG JAVA_FILE=target/*jar
COPY ${JAVA_FILE} /root/springboot-app/app.jar
ENTRYPOINT ["java", "-jar", "/root/springboot-app/app.jar"]
