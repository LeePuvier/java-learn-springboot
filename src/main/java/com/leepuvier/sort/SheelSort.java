package com.leepuvier.sort;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/30  8:56 PM
 * @ContentUse :
 */
public class SheelSort {

    public static int[] sheelSort(int[] data){

        long startTime = System.currentTimeMillis();

        int len = data.length;

        while (len != 0){

            len = len/2;
            //依据下标差值为（length/2）进行分组，分为（length/2）组
            for (int i = 0; i < len; i++) {
                //对每一组元素进行[直接插入排序]
                for (int j = i+len; j < data.length; j += len) {

                    //k为有序序列最后一位的位数
                    int k = j - len;
                    //要插入的元素
                    int temp = data[j];
                    //从后往前遍历
                    while (k >= 0 && data[k] > temp){
                        data[k+len] = data[k];
                        //向后移动len位
                        k -= len;
                    }
                    data[k+len] = temp;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时： " + String.valueOf(endTime - startTime));

        return data;

    }
}
