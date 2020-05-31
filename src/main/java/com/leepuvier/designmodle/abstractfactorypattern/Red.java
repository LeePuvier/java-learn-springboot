package com.leepuvier.designmodle.abstractfactorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  8:20 PM
 * @ContentUse :
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("调用Red中fill()");
    }
}
