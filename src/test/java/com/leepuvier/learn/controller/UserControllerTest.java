package com.leepuvier.learn.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootConfiguration()
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

    }

    @Test
    public void testUserController() throws Exception{


        RequestBuilder request = null;

        //1、获取UserList，为空

        request = get("/users/list");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));


        //2、post提交一个User
        request = post("/users/addUser")
                .param("id","2")
                .param("user_id","666666")
                .param("password","666666")
                .param("phone","666666")
                .param("email","")
                .param("wechat_unionid","666666")
                .param("wechattmp_openid","666666")
                .param("wechat_openid","666666")
                .param("avatar_url","666666")
                .param("city","666666")
                .param("nickname","666666")
                .param("country","666666")
                .param("gender","666666")
                .param("province","666666")
                .param("realname","666666")
                .param("id_card","666666");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("Add User Success")));



        //3、update
        request = put("/users/updateUser/2")
                .param("nickname","666666666666")
                .param("city","666666666666");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Update User Info Success")));

        //4、getUserById
        request = get("/users/getUser/2");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nickname").value("666666666666"));



        //5、deleteUserById

        request = delete("/users/deleteUser/2");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("Delete User Info Success")));


        //6、获取UserList，为空

        request = get("/users/list");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}
