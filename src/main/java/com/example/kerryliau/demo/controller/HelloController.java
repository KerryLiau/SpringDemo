package com.example.kerryliau.demo.controller;

import java.util.List;

import com.example.kerryliau.demo.entity.JsonObject;
import com.example.kerryliau.demo.entity.Response;
import com.example.kerryliau.demo.entity.dto.TwoInt32;
import com.example.kerryliau.demo.service.HelloService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/array/{array}")
    public Response<JsonObject> printArray(@PathVariable("array") Integer[] array) {
        helloService.testCircleNode(array);
        return Response.ok();
    }

    @GetMapping("/hello-all")
    public Response<List<JsonObject>> helloPostgres() {
        return Response.ok(helloService.findAllHelloData());
    }

    @GetMapping("/hello/{id}")
    public Response<JsonObject> helloPostgres(@PathVariable("id") int id) {
        return Response.ok(helloService.findHelloById(id));
    }

    @PutMapping("/hello-new/{id}/{name}")
    public Response<JsonObject> newHello(@PathVariable("id") int id, @PathVariable("name") String name) {
        helloService.newHello(id, name);
        return Response.ok();
    }

    @PostMapping("/hello-procedure-add")
    public Response<JsonObject> helloProcedureAdd(@RequestBody TwoInt32 param) {
        return Response.ok(helloService.helloProcedureAdd(param));
    }

    @PostMapping("/hello-procedure-max")
    public Response<JsonObject> helloProcedureMax(@RequestBody TwoInt32 param) {
        return Response.ok(helloService.helloProcedureMax(param));
    }

}
