package com.alura.challenge.foro_hub.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicDTO(
        @NotNull
        String topicTitle,
        @NotNull
        String topicMessage,
        @NotNull
        LocalDateTime topicDate

) {
}
