FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG DEPENDENCY=target/dependency
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]