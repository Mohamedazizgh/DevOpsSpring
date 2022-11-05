FROM openjdk:11
ADD target/achat-1.0.jar achat-1.0.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
