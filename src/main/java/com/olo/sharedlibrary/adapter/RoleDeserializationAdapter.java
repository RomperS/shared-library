package com.olo.sharedlibrary.adapter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.olo.sharedlibrary.security.authorities.Role;

import java.io.IOException;

public class RoleDeserializationAdapter extends JsonDeserializer<Role> {

    @Override
    public Role deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String roleName = jsonParser.getText();

        if (roleName == null || roleName.isEmpty()) {
            return null;
        }

        return Role.fromString(roleName);
    }
}
