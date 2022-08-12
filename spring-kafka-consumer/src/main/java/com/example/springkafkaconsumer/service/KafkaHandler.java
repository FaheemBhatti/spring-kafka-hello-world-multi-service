package com.example.springkafkaconsumer.service;

import com.example.springkafkahelloworldmultiservice.dto.RandomObjectDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaHandler {

    private final ObjectMapper objectMapper;

    public KafkaHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "hello-world-kafka-topic", containerFactory = "kafkaListenerContainerFactory", groupId = "hello-world-group")
    public void handleOrganizationCreated(String data) throws JsonProcessingException {
        RandomObjectDto randomObjectDto = objectMapper.readValue(data, RandomObjectDto.class);
        log.info("Start processing kafka data {}", randomObjectDto);
    }

}
