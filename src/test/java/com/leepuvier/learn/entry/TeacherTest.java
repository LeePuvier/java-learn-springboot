package com.leepuvier.learn.entry;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class TeacherTest {

    @Test
    public void test(){
        Teacher teacher = new Teacher(1, "Leepuvier", "Test Entity Techter");

        /**
         * AssertJ写法：流式写
         */
        Assertions.assertThat(teacher.getName().equals("Leepuvier"));

        /**
         * Junit写法
         */
        Assert.assertEquals("Leepuvier", teacher.getName());
    }
}