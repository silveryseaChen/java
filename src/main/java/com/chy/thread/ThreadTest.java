package com.chy.thread;

/**
 * Created by chy on 2018/11/19.
 */
public class ThreadTest {

    public static void main(String[] args) {

        ThreadTest test = new ThreadTest();
        for (int i=0; i<10;  i++) {
            test.new MyThread().start();
        }

    }

    class MyThread extends Thread{

        public void run() {
            for (int i=0;i < 10; i++){
                System.out.println(getName() + ":" + i);
                try{
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }


}
