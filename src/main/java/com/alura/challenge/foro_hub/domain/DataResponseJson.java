package com.alura.challenge.foro_hub.domain;

import com.alura.challenge.foro_hub.domain.topic.dto.DataResponseTopic;

public record DataResponseJson<T>(
        String message,
        T dataResponse
) {
}
