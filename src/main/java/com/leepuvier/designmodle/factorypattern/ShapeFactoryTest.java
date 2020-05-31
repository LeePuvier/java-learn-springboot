package com.leepuvier.designmodle.factorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  7:42 PM
 * @ContentUse :
 */
public class ShapeFactoryTest {

    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
    }
}
