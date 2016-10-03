package com.manthanhd.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by manthanhd on 02/10/2016.
 */
public class PingProducer {

    private final String topic;
    private final Producer<String, PingMessage> producer;

    public PingProducer(String topic) {
        final Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, PingSerializer.class.getName());
        producer = new KafkaProducer<String, PingMessage>(configProperties);
        this.topic = topic;
    }

    public static void main(String[] args) {
        final PingProducer producer = new PingProducer("PingTopic");
        producer.sendPing();
        producer.close();
    }

    public void sendPing() {
        final ProducerRecord<String, PingMessage> record = new ProducerRecord<String, PingMessage>(topic, new PingMessage());
        producer.send(record);
        producer.flush();
    }

    public void close() {
        producer.close(5, TimeUnit.SECONDS);
    }
}
