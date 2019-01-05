package com.chy.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chy on 2018/12/30.
 * 线程间交互
 * wait notify notifyAll
 * 实现多个线程交替输出的数字
 */
public class SynchronizedConditionTest {

    private volatile AtomicInteger index = new AtomicInteger(0);

    private static int threadCnt = 4;   //线程数
    private static int loopCnt = 50;    //每个线程循环次数

    public static void main(String[] args) {

        SynchronizedConditionTest test = new SynchronizedConditionTest();
        for(int i=0; i<threadCnt; i++){
            new Thread(test.new MyThread(i)).start();
        }

    }

    class MyThread implements Runnable{

        private int mod = 0;

        public MyThread(int m){
            this.mod = m;
        }

        public void run(){
            for (int i=0;i<50;i++){
                synchronized (index){
                    while (index.intValue() % threadCnt != mod){
                        try {
                            index.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(index.intValue() % threadCnt == mod){
                        System.out.println(Thread.currentThread().getName()+"-->"+index.intValue());
                        index.getAndIncrement();
                    }
                    index.notifyAll();
                }
            }
        }

    }


}
