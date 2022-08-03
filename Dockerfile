FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
