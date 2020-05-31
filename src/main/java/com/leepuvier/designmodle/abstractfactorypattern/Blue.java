package com.leepuvier.designmodle.abstractfactorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  8:21 PM
 * @ContentUse :
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("调用Blue中fill()");
    }
}
