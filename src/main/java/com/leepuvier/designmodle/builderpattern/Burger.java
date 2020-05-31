package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/29  9:57 AM
 * @ContentUse :
 */
public abstract class Burger implements Item {
    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public float prince() {
        return 0;
    }
}
