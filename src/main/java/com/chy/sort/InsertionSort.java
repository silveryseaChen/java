package com.chy.sort;

/**
 * Created by chy on 2018/12/1.
 * 插入排序
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 */
public class InsertionSort {

    public static void sort(int[] a){
        int loopCnt = 0;
        int swapCnt = 0;
        for (int i=0; i<a.length;i++) {
            for (int j=i; j > 0 &&  a[j] < a[j-1]; j--){
                int t = a[j];
                a[j] = a[j-1];
                a[j-1] = t;

                swapCnt++;
                loopCnt++;
            }

            Base.print(a);
        }
        System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
    }

}
