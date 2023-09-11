#FROM adoptopenjdk:11-jre-hotspot as builder
#ARG JAR_FILE=target/*.jar
#VOLUME /tmp
## COPY ${JAR_FILE} coordinates-to-address-service-1.0-SNAPSHOT.jar
## RUN java -Djarmode=layertools -jar coordinates-to-address-service-1.0-SNAPSHOT.jar extract
## RUN java -Djarmode=layertools -jar target/coordinates-to-address-service-1.0-SNAPSHOT.jar extract
#RUN java -Djarmode=layertools -jar target/coordinates-to-address-service-1.0-SNAPSHOT.jar
#MAINTAINER bmg13
FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["mvn", "spring-boot:run "]
MAINTAINER bmg13
EXPOSE 8888