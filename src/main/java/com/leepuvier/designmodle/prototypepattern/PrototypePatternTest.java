package com.leepuvier.designmodle.prototypepattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  8:36 PM
 * @ContentUse :
 */
public class PrototypePatternTest {

    public static void main(String[] args){
        ShapeCache.loadCache();
        ShapeCache.getShape("1");
    }
}
