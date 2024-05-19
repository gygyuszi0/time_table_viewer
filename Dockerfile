FROM openjdk:17-alpine3.14

COPY ./target/*-jar-with-dependencies.jar /application/time_table_viewer.jar
EXPOSE 8080

CMD ["java", "-jar", "/application/time_table_viewer.jar"]

