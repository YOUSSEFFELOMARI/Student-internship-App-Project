FROM openjdk:17
COPY target/bservatoireUizJava.jar bservatoireUizJava.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bservatoireUizJava.jar"]