FROM ubuntu:16.04

RUN apt-get update && apt-get install -y openjdk-8-jre-headless

ADD customer-processor-0.1.0.jar .

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar customer-processor-0.1.0.jar