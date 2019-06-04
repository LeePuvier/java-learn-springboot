package com.leepuvier.unittest.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leepuvier.JavaLearnApplication;
import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = JavaLearnApplication.class )
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@Transactional
@WebAppConfiguration
public class JunitTestServiceImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getJunitTestByIdWithRight() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/testcase/getJunitTestById")
                .param("id", "1")
                .accept(MediaType.ALL_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);

    }


    @Test
    public void getJunitTestByIdWithNull() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/testcase/getJunitTestById")
                .param("id", "")
                .accept(MediaType.ALL_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        Assert.assertEquals("", content);

    }

    @Test
    public void getJunitTestByCaseNameWithNull() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/testcase/getJunitTestByCaseName")
                .param("caseName", "")
                .accept(MediaType.ALL_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        Assert.assertEquals("", content);

    }

    @Test
    public void getJunitTestByCaseNameWithRight() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/testcase/getJunitTestByCaseName")
                .param("caseName", "test_01")
                .accept(MediaType.ALL_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        JSONObject jsonInfo = new JSONObject(content);
        Assert.assertEquals(200, status);
        Assert.assertEquals("test_01", jsonInfo.get("caseName"));

        System.out.println("---------------------->" + jsonInfo.get("caseName"));
    }

    @Test
    public void getJunitTestListWithRight() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/testcase/getJunitTestList")
                .param("caseResult", "1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        String jsonInfo = JSON.parseArray(mvcResult.getResponse().getContentAsString()).getJSONObject(0).get("caseName").toString();
        Assert.assertEquals(200, status);
        Assert.assertEquals("test_88", jsonInfo);
    }

    @Test
    public void updateJunitTestByIdWithNull() throws Exception {

        JunitTestDO junitTestDO = null;

        ObjectMapper mapper = new ObjectMapper();
        String jsonInfo = "{\"id\":88,\"caseName\":\"Mock Server Test\",\"caseResult\":2,\"caseResultDec\":\"Mock Server Test\"}";
        junitTestDO = mapper.readValue(jsonInfo, JunitTestDO.class);

        MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/testcase/updateJunitTestById")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("caseName", "Mock Server Test")
                .content(mapper.writeValueAsString(junitTestDO)))

//                .content(jsonInfo))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(400, status);
        Assert.assertEquals("", content);
    }

    @Test
    public void updateJunitTestByIdWithNullCaseName() throws Exception {

        JunitTestDO junitTestDO = null;

        ObjectMapper mapper = new ObjectMapper();
        String jsonInfo = "{\"id\":88,\"caseName\":\"Mock Server Test\",\"caseResult\":2,\"caseResultDec\":\"Mock Server Test\"}";
        junitTestDO = mapper.readValue(jsonInfo, JunitTestDO.class);

        MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/testcase/updateJunitTestById")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(junitTestDO)))

//                .content(jsonInfo))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(400, status);
        Assert.assertEquals("", content);
    }

    @Test
    public void updateJunitTestByIdWithNullCaseNames() throws Exception {

        JunitTestDO junitTestDO = null;

        ObjectMapper mapper = new ObjectMapper();
        String jsonInfo = "{\"id\":88,\"caseName\":\"Mock Server Test\",\"caseResult\":2,\"caseResultDec\":\"Mock Server Test\"}";
        junitTestDO = mapper.readValue(jsonInfo, JunitTestDO.class);

        MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/testcase/updateJunitTestById")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("caseName", "")
                .content(mapper.writeValueAsString(junitTestDO)))

//                .content(jsonInfo))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(400, status);
        Assert.assertEquals("", content);
    }

    @Test
    public void updateJunitTestByIdWithRightJson() throws Exception {

        JunitTestDO junitTestDO = null;

        ObjectMapper mapper = new ObjectMapper();
        String jsonInfo = "{\"id\":88,\"caseName\":\"Mock Server Test\",\"caseResult\":2,\"caseResultDec\":\"Mock Server Test\"}";
        junitTestDO = mapper.readValue(jsonInfo, JunitTestDO.class);

        MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/testcase/updateJunitTestById")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","88")
                .param("caseName", "Mock Server Test")
                .content(mapper.writeValueAsString(junitTestDO)))

//                .content(jsonInfo))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        Assert.assertEquals("true", content);
    }

    @Test
    public void updateJunitTestByIdWithRightObject() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/testcase/updateJunitTestById")
                .contentType(MediaType.ALL_VALUE)
                .param("id","88")
                .param("caseName","Test Post")
                .param("caseResult","2")
                .param("caseResultDec","Test Post"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        Assert.assertEquals("true", content);
    }

    @Test
    public void createJunitTestWithRight() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/testcase/createJunitTest")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id","99")
                .param("caseName","Test_99")
                .param("caseResult","2")
                .param("caseResultDec","Test_99"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
        Assert.assertEquals("1", content);
    }
}