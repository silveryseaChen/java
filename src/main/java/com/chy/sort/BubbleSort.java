package com.chy.sort;

import com.sun.deploy.util.ArrayUtil;

/**
 * Created by chy on 2018/12/1.
 * 冒泡排序
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 3.针对所有的元素重复以上的步骤，除了最后一个；
 重复步骤1~3，直到排序完成。
 */
public class BubbleSort {

    public static void sort(int[] a){

        int loopCnt = 0;
        int swapCnt = 0;
        for (int i=0; i< a.length; i++){
            for (int j=0; j<a.length-i-1; j++){
                if(a[j] > a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    swapCnt ++;
                }
                loopCnt ++;
            }
            Base.print(a);
        }
        System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
    }

}
