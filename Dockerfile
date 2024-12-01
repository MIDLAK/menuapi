# .\gradlew build -x test (тесты пропускаются, т.к. базы ещё нет)

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/build/libs/menu-0.1.3-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]