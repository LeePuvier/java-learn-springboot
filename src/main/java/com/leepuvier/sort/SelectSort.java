package com.leepuvier.sort;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/30  10:03 PM
 * @ContentUse :
 */
public class SelectSort {

    public static int[] selectSort(int[] data){


        long startTime = System.currentTimeMillis();

        //循环次数
        for (int i = 0; i < data.length; i++) {

            //当前数值
            int temp = data[i];
            //当前位置
            int position = i;

            //找到最小的值和位置
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < temp){
                    temp = data[j];
                    position = j;
                }
            }
            //进行交换
            data[position] = data[i];
            data[i] = temp;

        }

        long endTime = System.currentTimeMillis();
        System.out.println("简单选择排序耗时： " + String.valueOf(endTime - startTime));

        return data;
    }
}
