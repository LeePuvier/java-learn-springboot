package com.leepuvier.sort;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/29  9:36 AM
 * @ContentUse :
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] data){

        int temp;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j] > data[j+1]){
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时： " + String.valueOf(endTime - startTime));

        return data;

    }
}
