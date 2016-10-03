package com.manthanhd.kafka.ping.consumer;

import com.manthanhd.kafka.ping.deserializer.PingDeserializer;
import com.manthanhd.kafka.ping.model.PingMessage;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by manthanhd on 02/10/2016.
 */
public class PingConsumer {

    private final String topic;
    private final Consumer<String, PingMessage> consumer;

    public PingConsumer(String pingTopic) {
        final Properties configProperties = new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, PingDeserializer.class.getName());
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "1");
        configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");
        consumer = new KafkaConsumer<String, PingMessage>(configProperties);
        this.topic = pingTopic;
    }

    public static void main(String[] args) {
        final PingConsumer consumer = new PingConsumer("PingTopic");
        consumer.consume();
    }

    public void consume() {
        consumer.subscribe(Collections.singletonList(topic));
        final ConsumerRecords<String, PingMessage> consumerRecords = consumer.poll(100);
        try {
            while (true) {
                ConsumerRecords<String, PingMessage> records = consumer.poll(100);
                for (ConsumerRecord<String, PingMessage> record : records)
                    System.out.println(record.value());
            }
        }catch(WakeupException ex){
            System.out.println("Exception caught " + ex.getMessage());
        }finally{
            consumer.close();
            System.out.println("After closing KafkaConsumer");
        }
//        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
//            System.out.println(consumerRecord.value());
//        }
    }

}
