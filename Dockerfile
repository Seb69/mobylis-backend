FROM openjdk:9.0.1-jre-slim
WORKDIR /tmp
COPY ./build/libs/mobylis-backend.jar mobylis-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mobylis-backend.jar"]
