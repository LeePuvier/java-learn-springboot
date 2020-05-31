package com.leepuvier.designmodle.prototypepattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  8:27 PM
 * @ContentUse :
 */
public class Square extends Shape{

    public Square(){
        type = "Square";
    }
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
