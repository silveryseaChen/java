package com.chy.sort;

/**
 * Created by chy on 2018/12/7.
 * 堆排序
 * 子结点的键值或索引总是小于（或者大于）它的父节点。
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort {

    private static int loopCnt = 0;
    private static int swapCnt = 0;

    /**
     * 堆排序
     * @param a
     * @param m
     * @param n
     *
     * 假设 堆以数组方式存储
     * root 对应0
     * 0 的子节点 为 1 2
     * 1 的子节点为 3 4
     * 2 的子节点为 5 6
     * k 的子节点为 2k+1 2K+2
     */
    public static void sort(int[] a, int m, int n){

        if(m >= n) return;

        int level = (int)Math.ceil(Math.log(n-m+1)/Math.log(2));  //计算树的深度 1 2  3 ...

        for(int i=level-1; i > 0 && level > 0; i--){    //逐层循环处理 从倒数第i-1层开始处理4 3 .. 1
            for(int j=(int)Math.pow(2, i-1); j>0; j--){ //从该层最后一个参数开始处理 处理到第一个
                int currIndex = i==1? 0: (int)Math.pow(2, i-2) - 1 + j;
                //与其子节点进行比较
                int right = 2*currIndex+2;  //右子节点
                if(right < n && a[currIndex] < a[right]){
                    Base.swap(a, currIndex, right);
                    swapCnt++;
                }
                int left = 2*currIndex+1;   //左子节点
                if(left < n && a[currIndex] < a[left]){
                    Base.swap(a, currIndex, left);
                    swapCnt++;
                }

                loopCnt++;
            }
        }

        //处理完毕 将root 与最后一个元素互换
        Base.swap(a, m, n-1);
        System.out.println("循环次数："+loopCnt +", 交换次数："+swapCnt);
        swapCnt++;

        sort(a, m, n-1);
    }

}
