package com.manthanhd.kafka.customer.consumer;

import com.manthanhd.kafka.customer.deserializer.CustomerDeserializer;
import com.manthanhd.kafka.customer.model.Customer;
import com.manthanhd.kafka.ping.deserializer.PingDeserializer;
import com.manthanhd.kafka.ping.model.PingMessage;
import org.apache.kafka.clients.consumer.*;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class CustomerRegistrationConsumer {
    private static final String TOPIC_NAME = "CustomerRegistration";
    public static final int POLL_TIMEOUT = 500;
    private final Consumer<String, Customer> consumer;

    public CustomerRegistrationConsumer() {
        final Properties configProperties = new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomerDeserializer.class.getName());
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "1");
        configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");
        consumer = new KafkaConsumer<String, Customer>(configProperties);
    }

    public static void main(String[] args) {
        final CustomerRegistrationConsumer consumer = new CustomerRegistrationConsumer();
        consumer.consume();
    }

    public void consume() {
        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        System.out.println(String.format("Consuming topic %s with poll timeout %s.", TOPIC_NAME, POLL_TIMEOUT));
        while(true) {
            final ConsumerRecords<String, Customer> records = consumer.poll(POLL_TIMEOUT);
            for(ConsumerRecord<String, Customer> record : records) {
                final Customer customer = record.value();
                System.out.println(String.format("Received request for customer %s with ID %s", customer.getEmailAddress(), customer.getId()));
            }
        }
    }
}
