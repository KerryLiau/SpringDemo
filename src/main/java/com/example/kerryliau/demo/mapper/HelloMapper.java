package com.example.kerryliau.demo.mapper;

import java.util.List;

import com.example.kerryliau.demo.entity.JsonObject;
import com.example.kerryliau.demo.entity.dto.TwoInt32;
import com.example.kerryliau.demo.mapper.provider.HelloMapperProvider;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface HelloMapper {
    
    @Select("SELECT * FROM grand_sages_demo.hello_table;")
    public List<JsonObject> selectAllFromHello();

    @SelectProvider(type = HelloMapperProvider.class, method = "selectHello")
    public JsonObject selectHelloById(int id);

    @InsertProvider(type = HelloMapperProvider.class, method = "insertHello")
	public void insertHello(int id, String name);

    @SelectProvider(type = HelloMapperProvider.class, method = "callSpAdd")
	public JsonObject helloProcedureAdd(TwoInt32 param);

    @SelectProvider(type = HelloMapperProvider.class, method = "callSpMax")
	public JsonObject helloProcedureMax(TwoInt32 param);
}
