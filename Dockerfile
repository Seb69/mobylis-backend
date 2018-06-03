FROM openjdk:10.0.1-10-jre-slim-sid
WORKDIR /tmp
COPY ./build/libs/mobylis-backend.jar mobylis-backend.jar
EXPOSE 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mobylis-backend.jar"]