FROM openjdk:8
EXPOSE 8101
ADD target/ProcessPension-Microservice-0.0.1-SNAPSHOT.jar ProcessPension-Microservice-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/ProcessPension-Microservice-0.0.1-SNAPSHOT.jar"]