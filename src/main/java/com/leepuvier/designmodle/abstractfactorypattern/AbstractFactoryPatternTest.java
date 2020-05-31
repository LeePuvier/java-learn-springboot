package com.leepuvier.designmodle.abstractfactorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  8:34 PM
 * @ContentUse :
 */
public class AbstractFactoryPatternTest {

    public static void main(String[] args){
        AbstractFactory abstractFactoryShape = FactoryProducer.getFactory("SHAPE");
        Shape shapecircle = abstractFactoryShape.getShape("CIRCLE");
        shapecircle.draw();

        AbstractFactory abstractFactoryColor = FactoryProducer.getFactory("COLOR");
        Color shapeColor = abstractFactoryColor.getColor("RED");
        shapeColor.fill();
    }

}
