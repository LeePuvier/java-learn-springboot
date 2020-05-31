package com.leepuvier.sort;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/30  5:45 PM
 * @ContentUse :
 */
public class InsertSort {

    public static void insertSort(int[] data){

        long startTime = System.currentTimeMillis();

        int insertNum;

        //至少需要一个数,假设将在最后一个数作（从第二个数开始假设）为插入的数据，并开始从后往前对比进行排序
        for (int i = 1; i < data.length; i++) {

            insertNum = data[i];

            int j = i-1;

            while (j >= 0 && data[j] > insertNum){
                data[j+1] = data[j];
                j--;
            }

            //找到位置，插入当前元素
            data[j+1] = insertNum;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序耗时： " + String.valueOf(endTime - startTime));
    }
}
