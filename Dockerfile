FROM eclipse-temurin:11-jdk-alpine
ARG IP
ADD http://$IP:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","tpAchatProject"]
