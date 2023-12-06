FROM eclipse-temurin:17-alpine
COPY ./target/kameleoon-0.0.1.jar appKameleoon.jar

ENTRYPOINT ["java", "-jar","appKameleoon.jar"]