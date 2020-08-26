package com.leepuvier.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/8/26  7:01 PM
 * @ContentUse : 线程间通信模式：消息传递，Object类提供了线程间通信的方法：wait()、notify()、notifyaAl()
 */
public class ThreadSycNotifyTest {

    /**
     * 添加次数
     */
    private static final int COUNT = 10;

    public static void main(String[] args){
        // 定义一个锁对象
        Object lock = new Object();

        List<String> info = new ArrayList<>();

        // 实现 A线程

        Thread threadInfoA = new Thread(() -> {
            synchronized (lock){
                for (int i = 0; i <= COUNT; i++) {
                    info.add("abcd");
                    System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + info.size());
                    if(info.size() == 5){
                        // 唤醒 B 线程，notify()不释放锁
                        lock.notify();
                        break;
                    }
                }
            }
        });

        // 实现 B线程

        Thread threadInfoB = new Thread(() -> {
            while (true){
                synchronized (lock){
                    if(info.size() != 5){
                        try {
                            // wait()  释放锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
                }
            }

            for(int i = 0; i <= COUNT/2; i++) {
                info.add("abcd");
                System.out.println("线程B向list中添加一个元素，此时list中的元素个数为：" + info.size());
            }
        });

        // 先启动线程 B

        threadInfoB.start();

        // 再启动线程A

        threadInfoA.start();

    }
}
