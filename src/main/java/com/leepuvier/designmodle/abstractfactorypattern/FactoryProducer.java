package com.leepuvier.designmodle.abstractfactorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  8:31 PM
 * @ContentUse :
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        } else if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }

        return null;
    }
}
