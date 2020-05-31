package com.leepuvier.designmodle.prototypepattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  8:24 PM
 * @ContentUse :
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }


}
