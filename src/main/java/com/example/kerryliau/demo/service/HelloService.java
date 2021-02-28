package com.example.kerryliau.demo.service;

import java.util.List;

import com.example.kerryliau.demo.entity.JsonObject;
import com.example.kerryliau.demo.entity.dto.TwoInt32;
import com.example.kerryliau.demo.mapper.HelloMapper;
import com.grandsages.utils.CircleNode;

import org.springframework.stereotype.Service;


@Service
public class HelloService {

	private HelloMapper helloMapper;

	public HelloService(HelloMapper helloMapper) {
		this.helloMapper = helloMapper;
	}

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

	public List<JsonObject> findAllHelloData() {
		return helloMapper.selectAllFromHello();
	}

	public JsonObject findHelloById(int id) {
		return helloMapper.selectHelloById(id);
	}

	public void newHello(int id, String name) {
		helloMapper.insertHello(id, name);
	}

	public JsonObject helloProcedureAdd(TwoInt32 param) {
		return helloMapper.helloProcedureAdd(param);
	}

	public JsonObject helloProcedureMax(TwoInt32 param) {
		return helloMapper.helloProcedureMax(param);
	}
}
