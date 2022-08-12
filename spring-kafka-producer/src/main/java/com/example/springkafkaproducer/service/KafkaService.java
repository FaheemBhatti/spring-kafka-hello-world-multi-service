package com.example.springkafkaproducer.service;

import com.example.springkafkahelloworldmultiservice.dto.RandomObjectDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(RandomObjectDto dto) throws Exception {
        String key = dto.getRequestId();
        String message = createKafkaMessage(dto);
        kafkaTemplate.send("hello-world-kafka-topic", key, message);
    }

    private String createKafkaMessage(RandomObjectDto dto) throws Exception {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new Exception(e);
        }
    }

}