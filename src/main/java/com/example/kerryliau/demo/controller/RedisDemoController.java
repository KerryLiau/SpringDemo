package com.example.kerryliau.demo.controller;

import com.example.kerryliau.demo.entity.JsonObject;
import com.example.kerryliau.demo.entity.Response;
import com.example.kerryliau.demo.service.RedisService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Redis")
public class RedisDemoController {
    private RedisService redisService;

    public RedisDemoController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PutMapping("/put-string/{key}/{value}")
    public Response<JsonObject> redisSetValue(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisService.setValue(key, value);
        return Response.ok();
    }

    @GetMapping("/get-string/{key}")
    public Response<String> redisGetValue(@PathVariable("key") String key) {
        return Response.ok(redisService.getValue(key));
    }
}
