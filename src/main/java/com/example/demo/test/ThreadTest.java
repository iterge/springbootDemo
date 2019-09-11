package com.example.demo.test;

/**
 * @Description
 * @Author lph
 * @Date 2019/8/14 10:19
 */
public class ThreadTest implements Runnable {
    Integer tickets = 10;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(tickets > 0){
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+(tickets--)+"张车票");
                }
            }
        }
    }
}
