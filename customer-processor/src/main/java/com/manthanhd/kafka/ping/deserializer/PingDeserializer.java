package com.manthanhd.kafka.ping.deserializer;

import com.manthanhd.kafka.ping.model.PingMessage;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class PingDeserializer implements Deserializer<PingMessage> {
    private Map<String, ?> configs;
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.configs = configs;
        this.isKey = isKey;
    }

    @Override
    public PingMessage deserialize(String topic, byte[] data) {
        System.out.println("Received " + new String(data));
        return new PingMessage();
    }

    @Override
    public void close() {
        System.out.println("Closed");
    }
}
