package com.leepuvier.learn.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourceWemall {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getUserInfo() throws Exception {

        jdbcTemplate.queryForObject("select * from user limit 1", String.class);
    }
}
