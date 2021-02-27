package com.example.kerryliau.demo.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private StringRedisTemplate redis;

    public RedisService(StringRedisTemplate redis) {
        this.redis = redis;
    }

	public void setValue(String key, String value) {
        redis.opsForValue().set(key, value);
	}

    public String getValue(String key) {
        return redis.opsForValue().get(key);
	}
}
