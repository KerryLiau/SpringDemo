package com.example.kerryliau.demo.service;

import com.example.kerryliau.demo.entity.JsonObject;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public JsonObject hello(String someThing) {
        var data = new JsonObject();
        data.put("input", someThing);
		return data;
	}
    
}
