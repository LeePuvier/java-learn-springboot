package com.leepuvier.sort;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/31  9:44 AM
 * @ContentUse :
 */
public class QuickSort {

    public static int[]  quickSort(int[] data, int start, int end){

        long startTime = System.currentTimeMillis();

        //选择基准值
        int baseNum = data[start];
        //记录中间值
        int middleNum;
        int i = start;
        int j = end;
        do {
            while (data[i] < baseNum && i < end){
                i++;
            }
            while (data[j] > baseNum && j > start){
                j--;
            }
            if (i <= j){
                middleNum = data[i];
                data[i] = data[j];
                data[j] = middleNum;

                i++;
                j--;
            }
        } while (i <= j);

        if (start < j){
            quickSort(data, start, j);
        }
        if (end > i){
            quickSort(data, i, end);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时： " + String.valueOf(endTime - startTime));


        return data;
    }
}
