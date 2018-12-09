package com.chy.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chy on 2018/12/9.
 * 基数排序
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；
 * 依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
 * 最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 */
public class RadixSort {

    /**
     * 基数排序
     * @param a 待排序数组
     * @param max   待排序最大值
     */
    public static void sort(int[] a, int max){
        //计算 基 的 位数
        int r = String.valueOf(max).length();

        //基于每个 位进行排序 从低位往高位排 个 十 百 千。。。
        for (int i=0; i < r; i++){
            List<Integer>[] s = new List[10];    //存放基于 每个位上排序的字段 因为每位之后是 0-9 所以大小为10
            for (int v: a) {
                int rVal = getRadix(v, i);
                if(s[rVal] == null){
                    s[rVal] = new ArrayList();
                }
                s[rVal].add(v);
            }

            //取出 s中的值重新 放入a中
            int index = 0;
            for (List<Integer> l: s) {
                for (int v: l) {
                    a[index] = v;
                    index++;
                }
            }
            Base.print(a);
        }
    }

    /**
     * 取n 的 r位上的值
     * @param n
     * @param r
     * @return
     */
    private static int getRadix(int n, int r){
        String str = String.valueOf(n);
        int len = str.length();
        if(r >= len){
            return 0;
        } else {
            return Integer.valueOf(str.substring(len-r-1, len-r));
        }

    }

}
