package com.olo.sharedlibrary.adapter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.olo.sharedlibrary.security.authorities.Title;

import java.io.IOException;

public class TitleDeserializationAdapter extends JsonDeserializer<Title> {

    @Override
    public Title deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String titleName = jsonParser.getText();

        if (titleName == null || titleName.isEmpty()) {
            return null;
        }

        return Title.fromString(titleName);
    }
}
