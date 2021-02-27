package com.example.kerryliau.demo.controller;

import com.example.kerryliau.demo.entity.JsonObject;
import com.example.kerryliau.demo.entity.Response;
import com.example.kerryliau.demo.service.HelloService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloController {
    private ObjectMapper jsonMapper;
    private HelloService helloService;

    public HelloController(ObjectMapper jsonMapper, HelloService helloService) {
        this.jsonMapper = jsonMapper;
        this.jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.helloService = helloService;
    }

    @GetMapping("/{someThing}")
    public Response<JsonObject> hello(@PathVariable("someThing") String someThing) throws JsonProcessingException {
        var response = helloService.hello(someThing);
        return Response.ok(response);
    }

    @GetMapping("/test-array/{array}")
    public Response<JsonObject> printArray(@PathVariable("array") Integer[] array) {
        helloService.testCircleNode(array);
        return Response.ok();
    }

}
