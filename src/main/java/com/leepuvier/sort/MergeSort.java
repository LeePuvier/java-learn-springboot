package com.leepuvier.sort;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/31  10:37 AM
 * @ContentUse :
 */
public class MergeSort {

    public static int[] mergeSort(int[] data, int left, int right){

        long startTime = System.currentTimeMillis();

        //每组元素个数
        int t =1;

        int size = right - left + 1;

        while (t < size){
            //本次循环每组元素个数
            int s = t;

            t = 2 * s;

            int i = left;

            while (i + (t - 1) < size){
                merge(data, i, i + (s - 1), i + (t - 1));

                i += t;
            }

            if (i + (s - 1) < right){
                merge(data, i, i + (s - 1), right);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("归并排序耗时： " + String.valueOf(endTime - startTime));
        return data;
    }

    static void merge(int[] data, int p, int q, int r){
        int[] newData = new int[data.length];

        int s = p;

        int t = q + 1;

        int k = p;

        while (s <= q && t <= r){
            if (data[s] < data[t]){
                newData[k] = data[s];
                s++;
            }else {
                newData[k] = data[t];
                t++;
            }
            k++;
        }

        if (s == q + 1){
            newData[k++] = data[t++];
        }else {
            newData[k++] = data[s++];
        }

        for (int i = p; i <= r; i++) {
            data[i] = newData[i];
        }
    }
}
