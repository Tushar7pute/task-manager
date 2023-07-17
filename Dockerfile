FROM eclipse-temurin:11-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/taskmanager-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} taskmanager.jar
ENTRYPOINT ["java","-jar","/taskmanager.jar"]