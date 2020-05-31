package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/4/29  9:56 AM
 * @ContentUse :
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
