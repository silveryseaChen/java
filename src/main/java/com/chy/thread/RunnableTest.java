package com.chy.thread;

/**
 * Created by chy on 2018/11/19.
 */
public class RunnableTest {

    public static void main(String[] args) {

        RunnableTest test = new RunnableTest();
        for (int i=0; i<10;  i++) {
            new Thread(test.new MyRun("thread-"+i)).start();
        }

    }

    class MyRun implements Runnable{

        private String name;

        public MyRun(String name){
            this.name = name;
        }

        public void run() {
            for (int i=0;i < 10; i++){
                System.out.println(this.name + ":" + i);
                try{
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
