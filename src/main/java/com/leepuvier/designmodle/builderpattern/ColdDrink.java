package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/29  9:58 AM
 * @ContentUse :
 */
public abstract class ColdDrink implements Item {
    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public float prince() {
        return 0;
    }
}
