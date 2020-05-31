package com.leepuvier.designmodle.abstractfactorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  7:33 PM
 * @ContentUse :
 */
public class Rectangle implements Shape {


    @Override
    public void draw() {
        System.out.println("调用的是Rectangle中的draw()");
    }
}
