package com.manthanhd.kafka;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class PingSerializer implements Serializer<PingMessage> {
    private Map<String, ?> configs;
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.configs = configs;
        this.isKey = isKey;
    }

    @Override
    public byte[] serialize(String topic, PingMessage data) {
        return data.toString().getBytes();
    }

    @Override
    public void close() {
        System.out.println("Closed");
    }
}
