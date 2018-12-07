package com.chy.sort;

import java.util.Arrays;

/**
 * Created by chy on 2018/12/6.
 * 快速排序
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSort {

    private static int loopCnt = 0;
    private static int swapCnt = 0;

    public static void sort(int[] a, int left, int right){

        if(left >= right){return;}

        int p = a[left];    //基数数值
        int swapIndex = left;   //交换的位置
        int pp = left;  //当前基数所在的位置
        for (int i=left+1; i< right; i++) {
            if(a[i] < p){
                Base.swap(a, i, swapIndex);
                swapCnt++;
                if(pp == swapIndex){
                  pp  = i;
                }
                swapIndex++;
            }
            loopCnt++;
            System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
        }

        if(swapIndex != left){    //没有需要交换的数字
            Base.swap(a, swapIndex, pp);
            swapCnt++;
            System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
        }

        sort(a, left, swapIndex);
        sort(a, swapIndex+1, right);
    }


}
