package com.example.springkafkahelloworldmultiservice.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomObjectDto {

    private List<UUID> documentIds;

    private String receiverEmail;

    private String organizationId;

    private String requestId;

}
