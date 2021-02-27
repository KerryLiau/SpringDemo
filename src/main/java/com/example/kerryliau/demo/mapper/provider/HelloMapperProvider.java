package com.example.kerryliau.demo.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

@Component
public class HelloMapperProvider {
    private static final String MAIN_TABLE = "grand_sages_demo.hello_table";
    public String selectHello(int id) {
        return new SQL() {{
            SELECT("*")
            .FROM(MAIN_TABLE)
            .WHERE("id = " + id);
        }}.toString();
    }
}