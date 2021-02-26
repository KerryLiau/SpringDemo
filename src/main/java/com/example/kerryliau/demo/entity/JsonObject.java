package com.example.kerryliau.demo.entity;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonObject extends LinkedHashMap<String,Object> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonObject.class);
    private static final long serialVersionUID = 3587443917598326320L;

    @Override
    public String toString() {
        String result = "{}";
        try {
            result = OBJECT_MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.warn("Error when serializing JsonObject: ", e);
        }
        return result;
    }
    
    
}
