package com.example.kerryliau.demo.entity.dto;

import org.springframework.beans.factory.annotation.Value;

public class TwoInt32 {
    private Integer intA;
    private Integer intB;
    @Value("0")
    private Integer intResult;

    public Integer getIntA() {
        return intA;
    }

    public void setIntA(Integer intA) {
        this.intA = intA;
    }

    public Integer getIntB() {
        return intB;
    }

    public void setIntB(Integer intB) {
        this.intB = intB;
    }

    public Integer getIntResult() {
        return intResult;
    }

    public void setIntResult(Integer intResult) {
        this.intResult = intResult;
    }

    
}
