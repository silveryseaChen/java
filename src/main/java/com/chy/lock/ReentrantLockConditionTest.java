package com.chy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chy on 2018/12/30.
 * ReentrantLock 竞争条件 condition
 * condition.await() condition.signal() condition.signalAll()
 *
 * 实现多个线程交替输出的数字
 */
public class ReentrantLockConditionTest {

    private volatile int index = 0;
    private static int threadCnt = 4;   //线程数
    private static int loopCnt = 50;    //每个线程循环次数

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();  //条件对象

    public static void main(String[] args) {

        ReentrantLockConditionTest test = new ReentrantLockConditionTest();
        for(int i=0; i<threadCnt; i++){
            new Thread(test.new MyThread(i)).start();
        }

    }

    class MyThread implements Runnable{

        private int mod = 0;

        public MyThread(int mode){
            this.mod = mode;
        }

        public void run() {
            for (int i=0; i< loopCnt; i++) {

                lock.lock();
                try {
                    /*
                     *   此处如果换为if 当线程再次获取锁时 当满足!= this.mod 条件时 再await 而是执行while之后的代码
                     *   这样不能保证每次循环都有输出 最终的输出结果将 <
                     */
                    while (ReentrantLockConditionTest.this.index % threadCnt != this.mod) {
                        try {
//                            System.out.println(Thread.currentThread().getName() + "--await-->" + ReentrantLockConditionTest.this.index);
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (ReentrantLockConditionTest.this.index % threadCnt == this.mod) {
                        System.out.println(Thread.currentThread().getName() + "-->" + ReentrantLockConditionTest.this.index);
                        ReentrantLockConditionTest.this.index++;
                    }
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

    }

}
