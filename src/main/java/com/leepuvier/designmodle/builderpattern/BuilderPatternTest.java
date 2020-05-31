package com.leepuvier.designmodle.builderpattern;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/8  8:05 PM
 * @ContentUse :
 */
public class BuilderPatternTest {

    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareNonVegMeal();
        System.out.println("Veg Meal");
        meal.showItems();
        System.out.println("Total Cost : " + meal.getCost());
    }
}
