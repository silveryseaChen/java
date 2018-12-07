package com.chy.sort;

/**
 * Created by chy on 2018/12/1.
 *
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 *
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

 选择一个增量序列t1，t2，…，tk，其中tk=1；
 按增量序列个数k，对序列进行k 趟排序；
 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {

     //定义增量序列
    private static int[] t = new int[]{1};

    public static void sort(int[] a){
        int loopCnt = 0;
        int swapCnt = 0;
        Base.print(a);
        for (int i=0; i<t.length; i++) {
            for (int j=t[i]; j < a.length; j++){
                for(int k=0; k <= j/t[i]-1; k++){
                    System.out.println("i=="+i+",j=="+j+",k=="+k);
                    if(a[j-t[i]*k]<a[j-t[i]*(k+1)]){
                        int n= a[j-t[i]*k];
                        a[j-t[i]*k] = a[j-t[i]*(k+1)];
                        a[j-t[i]*(k+1)] = n;
                        swapCnt++;
                        loopCnt++;
                    }
                    Base.print(a);
                }
            }

        }
        System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
    }

}
