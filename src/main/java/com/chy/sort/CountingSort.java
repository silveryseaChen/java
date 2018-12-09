package com.chy.sort;

/**
 * Created by chy on 2018/12/9.
 * 计算排序
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 *
 *  以空间换时间  对于 数据值比较密集 较为合适
 */
public class CountingSort {

    /**
     * 计数排序
     * @param a 待排序数组
     * @param m 待排序a[i]最小值
     * @param n 待排序a[i]最大值
     */
    public static void sort(int[] a, int m, int n){
        //计数器
        int[] c = new int[n-m+1];

        for(int i=0; i<a.length; i++){
            c[a[i]]++;  //初始为0 出现一次+1
        }
        int index = 0;
        for(int i=0; i<c.length; i++){
            for(int j=0; j<c[i]; j++){
                a[index] = i;
                index++;
            }
        }
        Base.print(a);
        System.out.println("循环次数："+ (index+a.length) +", 交换次数："+0);
    }


}
