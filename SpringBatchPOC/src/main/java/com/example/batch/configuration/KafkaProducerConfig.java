package com.example.batch.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.Serializable;

import org.apache.kafka.clients.producer.KafkaProducer;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;


@Configuration
@EnableAutoConfiguration
@Component
public class KafkaProducerConfig  {

    Properties props = new Properties();
    KafkaProducer<String, String> producer;

    public void setProps(Properties props) {

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 1);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG,1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        props.put(ProducerConfig.SEND_BUFFER_CONFIG,20000);
        //props.put(ProducerConfig.CLIENT_ID_CONFIG,"client2");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(props);
    }

    public void  send(String msg)
    {
        producer.send(new ProducerRecord<String, String>("test2", msg ));

    }



}
