FROM maven:3.8.2-jdk-11
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "tpAchatProject-1.0.jar"]
