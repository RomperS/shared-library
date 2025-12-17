package com.olo.sharedlibrary.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.olo.sharedlibrary.adapter.TitleDeserializationAdapter;
import com.olo.sharedlibrary.security.authorities.Title;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdminUserCreatedEvent(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotNull
        Long serviceId,
        @JsonDeserialize(using = TitleDeserializationAdapter.class)
        Title title
) {
}
