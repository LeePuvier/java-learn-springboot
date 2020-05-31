package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/29  9:59 AM
 * @ContentUse :
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "VEG Burger";
    }

    @Override
    public float prince() {
        return 15f;
    }
}
