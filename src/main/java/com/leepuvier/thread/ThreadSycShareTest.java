package com.leepuvier.thread;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/8/26  6:40 PM
 * @ContentUse : 线程间通信模式：共享内存
 */

public class ThreadSycShareTest {

    /**
     * 定义一个共享变量实现通信
     */
    private static volatile boolean notice = false;

    /**
     * 添加次数
     */
    private static final int COUNT = 10;


    public static void main(String[] args){
        /**
         * 共享内存
         */
        List<String> info = new ArrayList<>();

        // 实现 A线程
        Thread threadInfoA = new Thread(() -> {
            for (int i = 0; i <= COUNT; i++) {
                info.add("abcd");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + info.size());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(info.size() == 5){
                    notice = true;
                    break;
                }
            }
        });


        // 实现 B线程

        Thread threadInfoB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到线程A通知，开始执行B的任务");
                    break;
                }
            }
            for (int i = 0; i <= COUNT/2 ; i++) {
                info.add("abcd");
                System.out.println("线程B向list中添加一个元素，此时list中的元素个数为：" + info.size());
            }
        });

        // 先启动线程B
        threadInfoB.start();

        // 在启动线程
        threadInfoA.start();

    }
}
