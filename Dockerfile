FROM openjdk:17
EXPOSE 8080
ADD target/octopus-game.jar octopus-game.jar
ENTRYPOINT ["java","-jar","/octopus-game.jar"]
