FROM openjdk:11
ADD target/achat.jar achat.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "achat.jar"]
