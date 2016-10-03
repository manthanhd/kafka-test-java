#!/bin/bash

echo "Starting Zookeeper..."
./kafka/bin/zookeeper-server-start.sh zookeeper.properties > zookeeper.log &

echo "Waiting for Zookeeper to come online..."
sleep 10

echo "Starting Kafka..."
./kafka/bin/kafka-server-start.sh server.properties