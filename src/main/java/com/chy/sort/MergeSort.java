package com.chy.sort;

/**
 * Created by chy on 2018/12/1.
 * 归并排序
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {

    private static int loopCnt = 0;

    public static int[] sort(int[] a, int m, int n){

        if(n == m){
            return new int[]{a[m]};
        } else if(n - m == 1){
            return merge(new int[]{a[m]}, new int[]{a[n]});
        } else {
            int d = (n-m)/2;
            int[] s1 = sort(a, m, m+d);
            int[] s2 = sort(a, m+d+1, n);
            return merge(s1, s2);
        }

    }

    /**
     * 默认 a b 已排好序
     * @param a
     * @param b
     * @return
     */
    public static int[] merge(int a[], int b[]){
        int[] c = new int[a.length+b.length];
        for(int i=0,j=0; i < a.length || j<b.length;){
            System.out.println("i="+i+",j="+j);
            if(i == a.length){
                c[i+j] = b[j];
                j++;
            } else if(j == b.length || a[i] <= b[j] ){
                c[i+j] = a[i];
                i++;
            } else {
                c[i+j] = b[j];
                j++;
            }
            loopCnt++;
            Base.print(c);
            System.out.println("循环次数："+loopCnt +", 交换次数："+loopCnt);
        }

        return c;
    }

}
