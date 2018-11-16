package com.chy.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by chy on 2018/11/16.
 * 读写锁
 * 多个读锁可以同时共享资源
 * 写锁和其它的锁都是互斥的 即：有一个线程获得写锁其它的线程都不能获取到锁（包含读锁和写锁）
 */
public class ReadAndWriteLockTest {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        ReadAndWriteLockTest test = new ReadAndWriteLockTest();
        test.new ReadThread().start();
        test.new ReadThread().start();

        test.new WriteThread().start();
//        test.new WriteThread().start();
    }

    class ReadThread extends Thread{

        @Override
        public void run() {
            lock.readLock().lock();
            try{
                for (int i = 0; i<100; i++) {
                    System.out.println(getName()+" read: " + i);
                    Thread.sleep(10);
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }

        }
    }

    class WriteThread extends Thread{

        @Override
        public void run() {
            lock.writeLock().lock();
            try{
                for (int i = 0; i<100; i++) {
                    System.out.println(getName()+" write: " + i);
                    Thread.sleep(10);
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }

        }
    }
}
