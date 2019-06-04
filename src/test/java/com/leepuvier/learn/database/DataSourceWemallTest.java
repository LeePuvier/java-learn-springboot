package com.leepuvier.learn.database;

import com.leepuvier.learn.JavaLearnApplicationTests;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class DataSourceWemallTest {

    private static final Log log = LogFactory.getLog(JavaLearnApplicationTests.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void getUserInfo() throws Exception {
        log.info("User表总人数为：" + jdbcTemplate.queryForObject("select count(*) from user", String.class));
    }

}