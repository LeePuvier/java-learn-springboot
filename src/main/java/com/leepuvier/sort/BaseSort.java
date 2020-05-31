package com.leepuvier.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : LeePuvier
 * @CreateTime : 2020/5/31  11:04 AM
 * @ContentUse :
 */
public class BaseSort {

    public static int[] baseSort(int[] data){


        long startTime = System.currentTimeMillis();

        //首先确定排序的趟数;

        int max = data[0];

        for (int i = 0; i < data.length; i++) {
            if (data[i] > max){
                max = data[i];
            }
        }

        int time = 0;

        //判断位数;
        while (max > 0){
            max /= 10;
            time ++;
        }

        //建立10个队列;

        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }

        //进行time次分配和收集;

        for (int i = 0; i < time; i++) {
            //分配数组元素;
            for (int j = 0; j < data.length; j++) {
                //得到数字的第time+1位数;
                int x = data[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);

                ArrayList<Integer> queue2 = queue.get(x);

                queue2.add(data[j]);

                queue.set(x, queue2);
            }

            //元素计数器
            int count = 0;

            //收集队列元素

            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0){
                    ArrayList<Integer> queue3 = queue.get(k);
                    data[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("基数排序耗时： " + String.valueOf(endTime - startTime));

        return data;
    }
}
