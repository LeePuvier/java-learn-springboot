package com.leepuvier.thread;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/8/26  2:07 PM
 * @ContentUse :
 */
public class ThreadTest {
    public static void main(String[] args){

        ExtendsThread T1 = new ExtendsThread("Thread-T-1");
        T1.start();

        ExtendsThread T2 = new ExtendsThread("Thread-T-2");
        T2.start();
        T2.setDaemon(true);

        ImplementsRunnable R1 = new ImplementsRunnable("Thread-R-1");
        R1.start();

        ImplementsRunnable R2 = new ImplementsRunnable("Thread-R-2");
        R2.start();

    }
}
