package com.example.kerryliau.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private Integer code = 0;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String message = "ok";
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private T data;

    public static Response<JsonObject> ok() {
        return new Response<JsonObject>();
    }

    public static <T> Response<T> ok(T data) {
        var response = new Response<T>();
        response.setData(data);;
        return response;
    }

}
