package com.leepuvier.sort;

import java.util.Arrays;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/31  11:33 AM
 * @ContentUse :
 */
public class SortTest {

    public static void main(String[] args){

        int[] data = new int[500];

        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 10000);
        }

        System.out.println("排序前的数组为："+ Arrays.toString(data));

//        BaseSort.baseSort(data);
//        BubbleSort.bubbleSort(data);
//        HeapSort.heapSort(data);
//        InsertSort.insertSort(data);

//        MergeSort.mergeSort(data, 0, data.length - 1);
//        QuickSort.quickSort(data, 0, data.length - 1);

//        SelectSort.selectSort(data);
//        SheelSort.sheelSort(data);

        System.out.println("排序后的数组为："+Arrays.toString(data));
    }
}
