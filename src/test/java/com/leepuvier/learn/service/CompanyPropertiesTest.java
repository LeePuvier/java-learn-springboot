package com.leepuvier.learn.service;

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

@RunWith( SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompanyPropertiesTest {

    private static final Log log = LogFactory.getLog(JavaLearnApplicationTests.class);

    @Autowired
    private CompanyProperties companyProperties;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() throws Exception{
//        Assert.assertEquals(companyProperties.getCompanyName(), "小二叉公司");

        log.info("随机员工号为：" + companyProperties.getEmploeeNumber());

        log.info("公司信息为：" + companyProperties.getCompanyDesc());
    }


    @Autowired
    @Qualifier("jdbcTemplatePrimary")
    protected JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc() throws Exception{
        log.info("User表总人数为：" + jdbcTemplate.queryForObject("select count(1) from user", String.class));
    }
}
