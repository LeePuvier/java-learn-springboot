package com.leepuvier.designmodle.builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  7:56 PM
 * @ContentUse :
 */
public class Meal {

    private List<Item> itemList = new ArrayList<Item>();

    public void addItem(Item item){
        itemList.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : itemList){
            cost += item.prince();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : itemList){
            System.out.print("Item：" + item.name());
            System.out.print(", Packing：" + item.packing().pack());
            System.out.println(", Price：" + item.prince());
        }
    }
}
