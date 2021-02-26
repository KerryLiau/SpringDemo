package com.example.kerryliau.demo.entity;

import java.math.BigDecimal;
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

    public String getString(String key) {
        return (String) this.get(key);
    }

    public Integer getInt32(String key) {
        return (Integer) this.get(key);
    }

    public Long getInt64(String key) {
        return (Long) this.get(key);
    }

    public BigDecimal getDecimal(String key) {
        return (BigDecimal) this.get(key);
    }

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
