#
# Build stage
#
FROM maven:3.6.3-jdk-8-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY target/*.jar /usr/src/app/it2-java-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/it2-java-api.jar"]
#docker build -t nome ./
#docker run -p 8080:8080 -t nome