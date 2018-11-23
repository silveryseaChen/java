package com.chy.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by chy on 2018/11/20.
 */
public class CallableTest {

    private Random random = new Random();

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTest test = new CallableTest();
        Future<Integer> future = executor.submit(test.new MyCall());
        System.out.println(future.get());

    }

    class MyCall implements Callable<Integer>{

        public Integer call() throws Exception {

            int num = random.nextInt(100);
            System.out.println(num);
            Thread.sleep(100);
            return num;
        }
    }


}
