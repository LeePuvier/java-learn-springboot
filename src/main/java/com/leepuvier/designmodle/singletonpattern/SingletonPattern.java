package com.leepuvier.designmodle.singletonpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/27  7:30 PM
 * @ContentUse :单例模式
 */
public class SingletonPattern {
    //构造函数私有化
    private SingletonPattern(){};

    //创建SingletonPattern的一个对象
    private static SingletonPattern instance;


    /**
     *  懒汉式，多线程不安全,获取唯一可用的对象：
     * @return
     */
    public static SingletonPattern getInstance1(){

        if (instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }

    /**
     * 懒汉式，多线程安全
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率，效率低
     * @return
     */
    public static synchronized SingletonPattern getInstance2(){
        if (instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }


    /**
     *
     * 描述：这种方式比较常用，但容易产生垃圾对象。
     * 优点：没有加锁，执行效率会提高。
     * 缺点：类加载时就初始化，浪费内存。
     *
     */
    private static SingletonPattern instance1 = new SingletonPattern();

    public static SingletonPattern getInstance(){
        return instance1;
    }

    /**
     * 双检锁/双重校验锁（DCL，即 double-checked locking）
     * 采用双锁机制，安全且在多线程情况下能保持高性能。
     * @return
     */

    private volatile static SingletonPattern singletonPattern;

    public static SingletonPattern getSingletonPattern(){

        if (singletonPattern == null){
            synchronized (SingletonPattern.class){
                if (singletonPattern == null){
                    singletonPattern = new SingletonPattern();
                }
            }
        }
        return singletonPattern;
    }


    /**
     * 登记式/静态内部类
     *
     */
    private static class SingletonPatternHolder{
        private static final SingletonPattern INSTANCE = new SingletonPattern();
    }

    public static final SingletonPattern getInstance4(){
        return SingletonPatternHolder.INSTANCE;
    }


    public void showMessage(){
        System.out.println("单例模式");
    }



}
