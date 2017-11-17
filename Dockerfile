FROM openjdk:8-jre-alpine
WORKDIR /tmp
#VOLUME /src/main/database/
COPY build/libs/mobylis-0.0.1-SNAPSHOT.jar mobylis.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mobylis.jar"]
