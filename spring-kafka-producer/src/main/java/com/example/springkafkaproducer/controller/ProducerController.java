package com.example.springkafkaproducer.controller;

import com.example.springkafkahelloworldmultiservice.dto.RandomObjectDto;
import com.example.springkafkaproducer.service.KafkaService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProducerController {

    private final KafkaService kafkaService;

    public ProducerController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/")
    public void send() throws Exception {
        RandomObjectDto data = RandomObjectDto.builder()
                .documentIds(List.of(UUID.randomUUID(), UUID.randomUUID()))
                .organizationId("organizationId")
                .receiverEmail("receiver@email.com")
                .requestId(UUID.randomUUID().toString()).build();
        kafkaService.send(data);
    }

}
