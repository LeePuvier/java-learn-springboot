package com.leepuvier.designmodle.prototypepattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  8:28 PM
 * @ContentUse :
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
