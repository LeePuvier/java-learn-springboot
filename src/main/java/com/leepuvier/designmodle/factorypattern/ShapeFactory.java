package com.leepuvier.designmodle.factorypattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/28  7:37 PM
 * @ContentUse :
 */
public class ShapeFactory {

    public Shape getShape(String shapType){

        if (shapType == null){
            return null;
        }

        if (shapType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if (shapType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if (shapType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }
}
