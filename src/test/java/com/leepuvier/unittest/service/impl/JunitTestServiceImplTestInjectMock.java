package com.leepuvier.unittest.service.impl;

import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;
import com.leepuvier.unittest.orm.mybatis.mapper.JunitTestMapper;
import com.leepuvier.unittest.service.JunitTestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith( SpringRunner.class )
public class JunitTestServiceImplTestInjectMock{

    @InjectMocks
    // 将所有的mock类注入到对象实例
    private JunitTestService junitTestService = new JunitTestServiceImpl();

    @Mock
    private JunitTestMapper junitTestMapper;

    @Before
    public void setUpHotAppData() {
        List<JunitTestDO> junitTestDOList = new ArrayList<>();

        JunitTestDO junitTestDO1 = new JunitTestDO();

        junitTestDO1.setId(77);
        junitTestDO1.setCaseResult(3);
        junitTestDO1.setCaseName("Test_77");
        junitTestDO1.setCaseResultDec("Test_77");

        JunitTestDO junitTestDO2 = new JunitTestDO();
        junitTestDO2.setId(99);
        junitTestDO2.setCaseResult(3);
        junitTestDO2.setCaseName("Test_99");
        junitTestDO2.setCaseResultDec("Test_99");

        junitTestDOList.add(junitTestDO1);
        junitTestDOList.add(junitTestDO2);
        when(junitTestMapper.getJunitTestList(3)).thenReturn(junitTestDOList);
        when(junitTestMapper.getJunitTestById(77)).thenReturn(junitTestDO1);
        when(junitTestMapper.getJunitTestByCaseName("Test_99")).thenReturn(junitTestDO2);
    }

    @Test
    public void getJunitTestById() {
        JunitTestDO junitTestDO = junitTestService.getJunitTestById(77);
        Assert.assertEquals("Test_77", junitTestDO.getCaseName());
    }

    @Test
    public void getJunitTestByCaseName() {
        JunitTestDO junitTestDO = junitTestService.getJunitTestByCaseName("Test_99");
        Assert.assertEquals("3", junitTestDO.getCaseResult().toString());
    }

    @Test
    public void getJunitTestList() {

        int infoSize = junitTestService.getJunitTestList(3).size();
        Assert.assertEquals(2, infoSize);


    }

    @Test
    public void saveJunitTest() {
    }

    @Test
    public void updateById() {
    }
}