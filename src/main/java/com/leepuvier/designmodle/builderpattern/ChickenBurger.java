package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  7:53 PM
 * @ContentUse :
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float prince() {
        return 20f;
    }
}
