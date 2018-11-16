package com.chy.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chy on 2018/11/16.
 * ReentrantLock 可重入锁 jdk1.5+
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        test.new MyThread().start();
        test.new MyThread().start();
    }

    class MyThread extends Thread{

        @Override
        public void run() {
            lock.lock();
            try{
                for (int i = 0; i<100; i++) {
                    System.out.println(getName()+": " + i);
                    Thread.sleep(10);
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

}
