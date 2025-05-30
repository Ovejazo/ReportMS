FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ReportMS.jar
ENTRYPOINT ["java", "-jar", "/ReportMS.jar"]