package com.leepuvier.learn.database;

import com.leepuvier.learn.JavaLearnApplicationTests;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class DataSourceConfigTest {

    private static final Log log = LogFactory.getLog(JavaLearnApplicationTests.class);

    @Autowired
    @Qualifier("jdbcTemplatePrimary")
    protected JdbcTemplate jdbcTemplatePrimary;

//    @Autowired
//    @Qualifier("jdbcTemplateSeondary")
//    protected JdbcTemplate jdbcTemplateSeondary;

    @Test
    public void testJdbc() throws Exception{
        log.info("测试环境User表总人数为：" + jdbcTemplatePrimary.queryForObject("select count(1) from user", String.class));
    }
//
//    @Test
//    public void devJdbc(){
//        log.info("开发环境User表总人数为：" + jdbcTemplateSeondary.queryForObject("select count(1) from user", String.class));
//    }
}
