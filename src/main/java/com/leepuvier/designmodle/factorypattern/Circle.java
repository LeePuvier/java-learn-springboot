package com.leepuvier.designmodle.factorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  7:36 PM
 * @ContentUse :
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("调用的是Circle中draw()");
    }
}
