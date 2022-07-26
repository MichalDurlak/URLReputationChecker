FROM openjdk:19-jdk
EXPOSE 8080
COPY target/URLReputationChecker-0.0.1-SNAPSHOT.jar /URLReputationChecker.jar
CMD ["java","-jar","/URLReputationChecker.jar"]