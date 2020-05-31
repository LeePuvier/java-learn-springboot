package com.leepuvier.designmodle.abstractfactorypattern;


/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  7:35 PM
 * @ContentUse :
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("调用的是Square中draw()");
    }
}
