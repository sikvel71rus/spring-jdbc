FROM openjdk:8-alpine3.9
EXPOSE 8090
COPY /target/spring-jdbc-1.0.jar /app/spring-jdbc-1.0.jar
CMD ["java","-jar","/app/spring-jdbc-1.0.jar"]