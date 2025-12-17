package com.olo.sharedlibrary.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.olo.sharedlibrary.adapter.RoleDeserializationAdapter;
import com.olo.sharedlibrary.security.authorities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StandardUserCreatedEvent(
        @NotNull
        Long serviceId,
        @JsonDeserialize(using = RoleDeserializationAdapter.class)
        Role role,
        @NotBlank
        String origin,
        @Email
        String mail
) {
}
