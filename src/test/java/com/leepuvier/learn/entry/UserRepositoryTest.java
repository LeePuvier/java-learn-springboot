package com.leepuvier.learn.entry;

import com.leepuvier.learn.JavaLearnApplicationTests;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static final Log log = LogFactory.getLog(JavaLearnApplicationTests.class);

    public static String getRandom(int length){
        String userInfo = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            userInfo += String.valueOf(random.nextInt(10));
        }
        return userInfo;
    }


    @Test
    public void testUser(){

        userRepository.save(new User( getRandom(6),"888888","888888","888888","888888","888888","888888","888888","888888","888888","888888","LeePuvier"));

//        log.info("通过指定信息获得用户信息：" + userRepository.findByNickname("888888").getCountry());

        log.info("总数据为：" + userRepository.findAll().size());

    }
}
