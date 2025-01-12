package com.alura.challenge.foro_hub.domain.user.dto;

import com.alura.challenge.foro_hub.domain.profile.Profile;
import com.alura.challenge.foro_hub.domain.profile.dto.ProfileDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotBlank
        String names,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password,
        @NotNull
        ProfileDTO profile
) {
}
