package com.chy.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by chy on 2018/12/27.
 * java 中的引用
 * 1.强引用 不会被gc
 * 2.软引用    内存不足是才会被gc
 * 3.弱引用    都会被gc
 * 4.虚引用    都会被gc
 */
public class ReferenceTest {


    public static void main(String[] args) {

        //1.强引用
        String  strong = new String("strong");
//        String strong = "abc";
        SoftReference<String> soft = new SoftReference<String>("soft");
        WeakReference<String> weak = new WeakReference<String>("weak");

        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<String> phantom = new PhantomReference<String>("weak", queue);

        System.out.println(String.format("%s %s %s %s", strong , soft.get(), weak.get(), phantom.get()));

        System.gc();    //不一定会进行 gc 处理

        System.out.println(String.format("%s %s %s %s", strong , soft.get(), weak.get(), phantom.get()));

    }

}
