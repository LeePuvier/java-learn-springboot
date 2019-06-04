package com.leepuvier.unittest.service.impl;

import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;
import com.leepuvier.unittest.orm.mybatis.mapper.JunitTestMapper;
import com.leepuvier.unittest.service.JunitTestService;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith( SpringRunner.class )
@Log4j2
public class JunitTestServiceImplTestInjectMock {

    @InjectMocks
    // 将所有的mock类注入到对象实例
    private JunitTestService junitTestService = new JunitTestServiceImpl();

    @Mock
    private JunitTestMapper junitTestMapper;

    @Test
    public void getJunitTestById() {
    }

    @Test
    public void getJunitTestByCaseName() {
    }

    @Test
    public void getJunitTestList() {
        List<JunitTestDO> junitTestDOList = new ArrayList<>();
        JunitTestDO junitTestDO1 = new JunitTestDO();
        junitTestDO1.setId(9999);
        junitTestDO1.setCaseResult(3);
        JunitTestDO junitTestDO2 = new JunitTestDO();
        junitTestDO2.setId(8888);
        junitTestDO2.setCaseResult(3);
        junitTestDOList.add(junitTestDO1);
        junitTestDOList.add(junitTestDO2);
        int infoSize = junitTestService.getJunitTestList(1).size();
        Assert.assertEquals(2, infoSize);


    }

    @Test
    public void saveJunitTest() {
    }

    @Test
    public void updateById() {
    }
}