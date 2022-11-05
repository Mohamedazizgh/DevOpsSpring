FROM openjdk:11
ADD target/achat.jar achat.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "achat.jar"]
