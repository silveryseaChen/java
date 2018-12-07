package com.chy.sort;

/**
 * Created by chy on 2018/12/1.
 * 选择排序
 * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {

    public static void sort(int[] a){
        int loopCnt = 0;
        int swapCnt = 0;
        for (int i=0; i<a.length;i++) {
            int minIndex = i;
            for (int j=i+1; j<a.length; j++){
                if(a[minIndex] > a[j]){
                    minIndex = j;
                }
                loopCnt++;
            }
            if(minIndex != i){  //交换
                int t = a[i];
                a[i] = a[minIndex];
                a[minIndex] = t;
                swapCnt++;
            }

            Base.print(a);
        }
        System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
    }


}
