package com.alura.challenge.foro_hub.domain.topic.dto;

import java.time.LocalDateTime;

public record DataResponseTopic(
        Long topicID,
        String topicTitle,
        String topicMessage,
        LocalDateTime topicDate
) {
}
