package com.leepuvier.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @Author : wecashtester
 * @CreateTime : 2019/6/4  下午9:38
 * @ContentUse ：Junit 参数化测试
 */

@RunWith( Parameterized.class )
public class FibonacciTest{

    @Parameterized.Parameters
    public static Collection<Object[]> parameterInfo(){
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    @Parameterized.Parameter
    public int location;

    @Parameterized.Parameter(1)
    public int execpectInfo;

    @Test
    public void test(){
        assertEquals(execpectInfo, Fibonacci.compute(location));
    }
}
