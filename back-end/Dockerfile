FROM openjdk:11-jdk
# Copia e renomeia .jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Expoe a porta 8080
EXPOSE 8080
# Executa jar
ENTRYPOINT ["java","-jar","/app.jar"]
