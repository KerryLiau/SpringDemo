package com.example.kerryliau.demo.controller;

import com.example.kerryliau.demo.entity.JsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloController {
    private ObjectMapper JsonMapper;

    public HelloController(ObjectMapper jsonMapper) {
        JsonMapper = jsonMapper;
        JsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @GetMapping("/{someThing}")
    @ResponseBody
    public JsonObject hello(@PathVariable("someThing") String someThing) throws JsonProcessingException {
        var response = new JsonObject();
        response.put("code", 0);
        response.put("message", "ok");

        var data = new JsonObject();
        data.put("input", someThing);

        response.put("data", data);
        System.out.println(JsonMapper.writeValueAsString(response));
        return response;
    }

}
