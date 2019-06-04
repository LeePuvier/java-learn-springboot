package com.leepuvier.learn.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getAllUser() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }
}
