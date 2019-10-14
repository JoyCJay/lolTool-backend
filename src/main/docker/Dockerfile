FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ADD spring-boot-docker-1.0.jar app.jar
ADD lol-loupe-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]