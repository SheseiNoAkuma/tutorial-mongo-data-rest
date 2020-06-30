FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/mongo-rest-0.0.1-SNAPSHOT.jar /app/mongo-rest.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/mongo-rest.jar"]
