package com.example.kerryliau.demo.mapper.provider;

import com.example.kerryliau.demo.entity.dto.TwoInt32;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

@Component
public class HelloMapperProvider {
    
    private static final String MAIN_TABLE = "grand_sages_demo.hello_table";
    
    public String selectHello(int id) {
        var sql = new SQL();
        sql.SELECT("*")
            .FROM(MAIN_TABLE)
            .WHERE("id = " + id)
        ;
        return sql.toString();
    }

    public String insertHello(int id, String name) {
        var sql = new SQL();
        sql.INSERT_INTO(MAIN_TABLE)
            .INTO_COLUMNS("id", "str_data")
            .INTO_VALUES(String.valueOf(id), addQuote(name))
        ;
        return sql.toString();
    }

    public String callSpAdd(TwoInt32 param) {
        return "CALL grand_sages_demo.sp_add(#{intA}, #{intB}, #{intResult})";
    }

    public String callSpMax(TwoInt32 param) {
        return "CALL grand_sages_demo.sp_max(#{intA}, #{intB}, #{intResult})";
    }

    private String addQuote(String string) {
        return "'" + string + "'";
    }
}