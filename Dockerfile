FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/skill-matrix-api-0.0.1-SNAPSHOT.jar skill-matrix-api.jar
ENTRYPOINT ["java","-jar","/skill-matrix-api.jar","-Dspring.profiles.active","env"]