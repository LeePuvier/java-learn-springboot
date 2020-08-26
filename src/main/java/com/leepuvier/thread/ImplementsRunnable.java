package com.leepuvier.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/8/26  2:06 PM
 * @ContentUse :
 */

@Slf4j
public class ImplementsRunnable implements Runnable {

    /**
     * 线程
     */
    private Thread threadInfo;

    /**
     * 线程名称
     */
    private String threadName;

    // 空参构造

    ImplementsRunnable(String name){
        this.threadName = name;
        System.out.println("创建线程：" + threadName);
    }

    public void start(){
        System.out.println("准备线程：" + threadName);
        if(threadInfo == null){
            threadInfo = new Thread(this, threadName);
            threadInfo.start();
        }
    }

    @Override
    public void run() {
        System.out.println("运行线程：" + threadName);

        try {
            for(int i = 0; i < 5; i++){
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + " 阻塞" );
            e.printStackTrace();
        }
        System.out.println("Thread: " + threadName + " 退出" );
    }
}
