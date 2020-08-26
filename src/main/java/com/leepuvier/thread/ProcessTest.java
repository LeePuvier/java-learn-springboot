package com.leepuvier.thread;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/8/26  3:27 PM
 * @ContentUse :
 */

@Slf4j
public class ProcessTest {
    public static void main(String[] args){
        try {
            String process = Runtime.getRuntime().exec("ls").toString();
            System.out.println(process);
        } catch (IOException e) {
            log.info("进程抛出异常为：{}",  e.toString());
        }
    }
}
