package com.leepuvier.designmodle.singletonpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/27  7:38 PM
 * @ContentUse :
 */
public class SingletonPatternTest {

    public static void main(String[] args){

        //获取唯一可用的对象

        SingletonPattern singletonPattern = SingletonPattern.getInstance();

        singletonPattern.showMessage();
    }
}
