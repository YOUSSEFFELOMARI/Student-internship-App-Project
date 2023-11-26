FROM openjdk:17
COPY target/ObservatoireUizJava.jar ObservatoireUizJava.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ObservatoireUizJava.jar"]