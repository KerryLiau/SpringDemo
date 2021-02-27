package com.example.kerryliau.demo.service;

import com.example.kerryliau.demo.entity.JsonObject;
import com.grandsages.utils.CircleNode;

import org.springframework.stereotype.Service;


@Service
public class HelloService {

	public JsonObject hello(String someThing) {
        var data = new JsonObject();
        data.put("input", someThing);
		return data;
	}
    
	public JsonObject testCircleNode(Integer[] array) {
		var data = new JsonObject();
		var node = new CircleNode<Integer>(100);
		node.add(array);
		node.forEachNext(System.out::println);
		return data;
	}
}
