package com.chy.lock;

/**
 * Created by chy on 2018/11/16.
 * synchronized
 * 方法 持有的是对象的锁
 * 语句块 只有对象的锁
 * 静态方法 持有的是类的锁
 */

public class SynchronizedTest {

    private String lock = "1";

    public static void main(String[] args) {

        SynchronizedTest test = new SynchronizedTest();
//        test.new MyRunMethod().start();
//        test.new MyRunMethod().start();

        test.new MyRunBlock().start();
        test.new MyRunBlock().start();

    }

    /**
     * 去掉 synchronized 线程交替无规律打印信息
     * 保留 synchronized 一个线程结束输出 另一个线程才输出
     * @param threadName
     */
    private synchronized void get(String threadName) {
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName + ":synchronized method ... " + i);
            get1(threadName, i);
            try{
                Thread.sleep(10);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 可重入锁 即如果锁的是同一个对象，锁还可以调用锁
     *
     * @param threadName
     */
    private synchronized void get1(String threadName, int i) {
        System.out.println(threadName + ":synchronized method reentrant... " + i);
    }

    /**
     * 同步方法
     */
    class MyRunMethod extends Thread {

        public void run() {
            get(this.getName());
        }
    }

    /**
     * 同步代码块
     */
    class MyRunBlock extends Thread {

        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + ":synchronized block ... " + i);
                    try{
                        Thread.sleep(10);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
