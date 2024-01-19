FROM maven:3.8.4-openjdk-17 As builder
WORKDIR /app
COPY ./src ./src
RUN mvn clean package


FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target