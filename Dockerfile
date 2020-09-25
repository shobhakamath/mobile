FROM maven:3.5-jdk-8-alpine
WORKDIR /
ADD . //
EXPOSE 8080
RUN mvn package -DskipTests
ENTRYPOINT  [ "mvn", "spring-boot:run"]