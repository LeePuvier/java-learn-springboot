package com.leepuvier.designmodle.abstractfactorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  8:21 PM
 * @ContentUse :
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("调用Creen中fill()");
    }
}
