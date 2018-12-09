package com.chy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chy on 2018/12/9.
 * 桶排序
 *
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 * 桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 *
 * 设置一个定量的数组当作空桶；
 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 对每个不是空的桶进行排序；
 从不是空的桶里把排好序的数据拼接起来。
 */
public class BucketSort {

    //设置默认桶容量大小 值的范围
    private final static int BUCKET_CAPACITY = 100; //eg 1-100 101-200

    /**
     * 桶排序
     * @param a 待排序数组
     * @param m 最大值
     * @param n 最小值
     */
    public static void sort(int[] a, int m , int n){

        //计算桶数量
        int bucketSize = (int)Math.ceil(n/BUCKET_CAPACITY);
        List<Integer>[] bucket = new List[bucketSize];
        for(int v: a){  //a 存入 bucket 中
            int bucketIndex = (int)Math.floor(v/BUCKET_CAPACITY);
            if(bucket[bucketIndex] == null){
                bucket[bucketIndex] = new ArrayList();
            }
            bucket[bucketIndex].add(v);
        }
        System.out.println(String.format("桶数据为%s", Arrays.deepToString(bucket)));

        //对每个通进行排序 本次采用 快速排序
        for (int i=0; i<bucketSize; i++) {
            if(bucket[i] != null){
                int[] bucketArray = bucket[i].stream().mapToInt(Integer::intValue).toArray();
                QuickSort.sort(bucketArray, 0, bucket[i].size());
                bucket[i] = Arrays.stream(bucketArray).boxed().collect(Collectors.toList());
            }

        }

        //最终结果放入a中
        int index = 0;
        for (List<Integer> iBucket: bucket) {
            if(iBucket == null) break;
            for (Integer v: iBucket) {
                a[index] = v;
                index ++;
            }
        }

        Base.print(a);

    }


}
