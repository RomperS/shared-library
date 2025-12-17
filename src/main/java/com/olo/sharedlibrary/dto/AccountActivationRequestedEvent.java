package com.olo.sharedlibrary.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record AccountActivationRequestedEvent(
        @Email
        String mail,
        @NotBlank
        String credentialToken,
        @NotNull
        Instant expireAt
) {
}
