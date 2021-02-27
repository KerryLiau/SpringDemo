package com.example.kerryliau.demo.mapper;

import com.example.kerryliau.demo.entity.JsonObject;
import com.example.kerryliau.demo.mapper.provider.HelloMapperProvider;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HelloMapper {
    
    @Select("SELECT * FROM grand_sages_demo.hello_table;")
    public JsonObject selectAllFromHello();

    @SelectProvider(type = HelloMapperProvider.class, method = "selectHello")
    public JsonObject selectHelloById(int id);
}
