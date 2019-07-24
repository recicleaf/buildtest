FROM openjdk:11-slim

COPY ./target/hello-world.jar /hello-world.jar

CMD ["/usr/bin/java", "-jar", "/hello-world.jar"]