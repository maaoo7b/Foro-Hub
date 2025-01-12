package com.alura.challenge.foro_hub.domain.user.dto;

import com.alura.challenge.foro_hub.domain.profile.Profile;

public record DataResponseUser(
        Long id,
        String names,
        String email,
        String password,
        Profile profile
) {
}
