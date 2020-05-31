package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  7:55 PM
 * @ContentUse :
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float prince() {
        return 3.5f;
    }
}
