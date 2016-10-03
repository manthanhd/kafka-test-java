FROM ubuntu:16.04

RUN apt-get update && apt-get install -y openjdk-8-jre-headless
ADD http://apache.mirror.anlx.net/zookeeper/zookeeper-3.4.9/zookeeper-3.4.9.tar.gz .
RUN tar -xzf zookeeper-3.4.9.tar.gz && ln -sf zookeeper-3.4.9 zookeeper && rm -rf zookeeper-3.4.9.tar.gz

ADD zookeeper.properties ./zookeeper/conf/zoo.cfg
ADD launch.sh .

RUN chmod u+x launch.sh

EXPOSE 2181

ENTRYPOINT bash launch.sh