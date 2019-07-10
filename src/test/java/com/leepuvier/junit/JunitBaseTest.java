package com.leepuvier.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StopWatch;
import org.testng.annotations.BeforeClass;

/**
 * @Author : wecashtester
 * @CreateTime : 2019/6/6  下午3:02
 * @ContentUse ：
 */
@Slf4j
@RunWith( SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class JunitBaseTest {

    private static Logger log = LoggerFactory.getLogger(JunitBaseTest.class);
    //定义计时器
    public static StopWatch sw;

    static {
        sw = null;
    }

    @BeforeClass
    public static void setUpBeforeClass(){
        sw = new StopWatch();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        log.info("**************************************************************");
        log.info("单元测试计时统计：{}", sw.prettyPrint());
        log.info("**************************************************************");
    }

    @Before
    public void setUp() throws Exception {
        log.info("开始测试-----------------");
    }

    @After
    public void tearDown() throws Exception {
//        sw.stop();
        log.info("测试结束-----------------");
    }

}
