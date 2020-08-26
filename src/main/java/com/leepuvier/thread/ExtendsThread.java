package com.leepuvier.thread;

import org.jetbrains.annotations.NotNull;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/8/26  2:02 PM
 * @ContentUse :
 */
public class ExtendsThread extends Thread{

    /**
     * 线程
     */
    private Thread threadInfo;

    /**
     * 线程名
     */
    private String threadName;


    ExtendsThread(String name){
        this.threadName = name;
        System.out.println("创建线程：" + threadName);
    }

    @Override
    public void start(){
        if(null == threadInfo){
            threadInfo = new Thread(this, threadName);
            threadInfo.start();
        }
    }

    @Override
    public void run(){
        System.out.println("运行线程：" + threadName);

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + "阻塞");
        }

        System.out.println("Thread " +  threadName + "退出");
    }
}
