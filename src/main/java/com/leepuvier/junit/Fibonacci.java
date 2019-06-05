package com.leepuvier.junit;

/**
 * @Author : wecashtester
 * @CreateTime : 2019/6/4  下午9:45
 * @ContentUse ：
 */
public class Fibonacci {
    public static int compute(int n) {
        int result = 0;
        if(n <= 1){
            result = n;
        }else {
            result = compute(n - 1) + compute(n - 2);
        }
        return result;
    }
}