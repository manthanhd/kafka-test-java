FROM ubuntu:16.04

RUN apt-get update && apt-get install -y openjdk-8-jre-headless
ADD http://apache.mirror.anlx.net/kafka/0.10.0.1/kafka_2.11-0.10.0.1.tgz .
RUN tar -xzf kafka_2.11-0.10.0.1.tgz && ln -sf kafka_2.11-0.10.0.1 kafka && rm -rf kafka_2.11-0.10.0.1.tgz

ADD server.properties .
ADD launch.sh .

RUN chmod u+x launch.sh

EXPOSE 9092

ENTRYPOINT bash launch.sh