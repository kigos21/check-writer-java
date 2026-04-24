FROM amazoncorretto:21-alpine

WORKDIR /app

COPY .mvn .mvn
COPY compose.yaml compose.yaml
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY pom.xml pom.xml

RUN ./mvnw dependency:go-offline

COPY src src

EXPOSE 8080

CMD [ "./mvnw", "spring-boot:run" ]
