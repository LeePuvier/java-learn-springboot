package com.leepuvier.learn.entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class TeacherMongoTest {

    @Autowired
    private TeacherReponsitory teacherReponsitory;

    @Before
    public void setUp() throws Exception {
        teacherReponsitory.deleteAll();
    }

    @Test
    public void testMongo() throws Exception{
        teacherReponsitory.save(new Teacher(1, "LeePuvier", "LeePuvier"));

        Assert.assertEquals(1, teacherReponsitory.findAll().size());
    }
}
