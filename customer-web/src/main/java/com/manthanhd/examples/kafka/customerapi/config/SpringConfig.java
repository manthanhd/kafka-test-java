package com.manthanhd.examples.kafka.customerapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manthanhd.examples.kafka.customerapi.model.Customer;
import com.manthanhd.examples.kafka.customerapi.serializer.CustomerSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by manthanhd on 03/10/2016.
 */
@Configuration
public class SpringConfig {

    @Bean
    public Producer<String, Customer> producer() {
        final Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomerSerializer.class.getName());
        return new KafkaProducer<String, Customer>(configProperties);
    }

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }

}
