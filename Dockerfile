FROM openjdk:9.0.1-jre-slim
WORKDIR /tmp
COPY ./build/libs/mobylis-0.0.1-SNAPSHOT.jar mobylis.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mobylis.jar"]
