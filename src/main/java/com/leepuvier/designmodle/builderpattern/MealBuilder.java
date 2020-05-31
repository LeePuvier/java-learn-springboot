package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  8:02 PM
 * @ContentUse :
 */
public class MealBuilder {

    public Meal prepareVegeMeal(){
        Meal meal = new Meal();

        meal.addItem(new VegBurger());
        meal.addItem(new Coke());

        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();

        meal.addItem(new ChickenBurger());
        meal.addItem(new Pesi());

        return meal;
    }
}
